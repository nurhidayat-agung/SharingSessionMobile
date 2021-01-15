package id.kalbenutritionals2021.ssmobile.context

import id.kalbenutritionals2021.ssmobile.network.AuthService
import id.kalbenutritionals2021.ssmobile.repo.AuthRepo
import id.kalbenutritionals2021.ssmobile.util.*
import id.kalbenutritionals2021.ssmobile.viewmodel.AuthVM
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


val kalbeApiModule = module {

    single {
        return@single OkHttpClient.Builder()
            .connectTimeout(Constants.ConectionTag.timeOut, TimeUnit.SECONDS)
            .readTimeout(Constants.ConectionTag.timeOut, TimeUnit.SECONDS)
            .writeTimeout(Constants.ConectionTag.timeOut, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(AuthenticationInterceptorRefreshToken(get(),androidContext()))
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.ConectionTag.baseUrl)
            .client(get())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonWithDate()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }


    single {
        createApiService<AuthService>(
                get()
        )
    }

}

val utilModule = module {

    single {
        SharedPref(androidContext())
    }

}

val vmModule = module {
    single { AuthVM(get()) }
}


val repoModule = module {
    single { AuthRepo(get(),get()) }
}
