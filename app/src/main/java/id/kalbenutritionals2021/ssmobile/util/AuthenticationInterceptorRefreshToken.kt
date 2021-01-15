package id.kalbenutritionals2021.ssmobile.util

import android.content.Context
import android.os.Build
import android.util.Base64
import androidx.annotation.RequiresApi
import id.kalbenutritionals2021.ssmobile.network.AuthService
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class AuthenticationInterceptorRefreshToken(
    private val sharedPref: SharedPref,
    private val context: Context
) :
    Interceptor {
    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val originalRequest = chain.request()
        val authenticationRequest =
            request(originalRequest, sharedPref.getString(Constants.AuthTag.tagToken))
        val initialResponse = chain.proceed(authenticationRequest)
        val key = "PrZVUW7kdz7ep8JvrTdqIs8EPVMa"
        val secret = "OzcuLDDcJJkW66ePFykYWboLNmMa"
        // val basicString = Constants.WSO.Key + ":" + Constants.WSO.Secret
        val basicString = "$key:$secret"
        // todo emulator
        /*
        val encodedBasicString: String =
            Base64.getEncoder().encodeToString(basicString.toByteArray())
         */
        val encodedBasicString: String = android.util.Base64.encodeToString(
            basicString.toByteArray(),
            Base64.DEFAULT
        ).replace("\\n".toRegex(), "").replace("\\s".toRegex(), "")
            .replace("\\t".toRegex(), "");

        when {
            initialResponse.code() == 403 || initialResponse.code() == 401 -> {
                val token: String = sharedPref.getString(Constants.AuthTag.tagToken, "")

                val okhttp = OkHttpClient.Builder()
                    .connectTimeout(Constants.ConectionTag.timeOut, TimeUnit.SECONDS)
                    .readTimeout(Constants.ConectionTag.timeOut, TimeUnit.SECONDS)
                    .writeTimeout(Constants.ConectionTag.timeOut, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .addInterceptor { chain ->
                        var value = if (chain.request().url().pathSegments()[0] == "token") {
                            "Basic $encodedBasicString"
                        } else {
                            "Bearer $token"
                        }

                        val req = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", value)
                            .build()
                        return@addInterceptor chain.proceed(req)
                    }
                    .build()

                val builder = Retrofit.Builder()
                    .baseUrl(Constants.ConectionTag.baseUrl)
                    .client(okhttp)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()


                return if (originalRequest.url().pathSegments()[0] == "token") {
                    val newAuthenticationRequest = originalRequest.newBuilder().addHeader(
                        "Authorization"
                        , "Basic $encodedBasicString"
                    ).build()
                    chain.proceed(newAuthenticationRequest)
                } else {

                    var responseNewTokenLoginModel =
                        builder.create(AuthService::class.java).getTokenSync(
                            Constants.AuthTag.client_grant_type
                        ).execute()

                    while (responseNewTokenLoginModel.code() != 200) {
                        responseNewTokenLoginModel =
                            builder.create(AuthService::class.java).getTokenSync(
                                Constants.AuthTag.client_grant_type
                            ).execute()
                    }

                    return when {
                        responseNewTokenLoginModel.code() != 200 -> {
                            null
                        }
                        else -> {
                            responseNewTokenLoginModel.body()?.accessToken?.let {
                                sharedPref.putString(Constants.AuthTag.tagToken, it)
                            }

                            val newAuthenticationRequest = originalRequest.newBuilder().addHeader(
                                "Authorization",
                                "Bearer " + responseNewTokenLoginModel.body()?.accessToken
                            ).build()
                            chain.proceed(newAuthenticationRequest)
                        }
                    }
                }
            }
            else -> return initialResponse
        }

    }

    private fun request(originalRequest: Request, oldToken: String): Request {

        return originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $oldToken").build()

    }
}