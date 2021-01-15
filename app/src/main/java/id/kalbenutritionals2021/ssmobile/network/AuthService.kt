package id.kalbenutritionals2021.ssmobile.network

import id.kalbenutritionals2021.ssmobile.model.RespToken
import id.kalbenutritionals2021.ssmobile.model.general.clsGlobalAPI
import id.kalbenutritionals2021.ssmobile.util.Constants
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface AuthService {

    @FormUrlEncoded
    @POST("token")
    fun getTokenSync(
        @Field("grant_type") grantType: String?
    ): Call<RespToken>

    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("grant_type") grantType: String?
    ): Observable<RespToken>

    @Headers("Content-Type: application/json")
    @POST("${Constants.ConectionTag.basePath}checkVersion")
    fun checkVersion(@Body clsGlobalAPI: clsGlobalAPI): Observable<clsGlobalAPI>


    @Headers("Content-Type: application/json")
    @POST("${Constants.ConectionTag.basePath}checkVersion")
    fun checkSpeed(@Body clsGlobalAPI: clsGlobalAPI): Call<clsGlobalAPI>


    @Headers("Content-Type: application/json")
    @POST("${Constants.ConectionTag.basePath}checkRole")
    fun getRole(@Body clsGlobalAPI: clsGlobalAPI): Observable<clsGlobalAPI>


    @Headers("Content-Type: application/json")
    @POST("${Constants.ConectionTag.basePath}loginMobile")
    fun loginMobile(@Body clsGlobalAPI: clsGlobalAPI): Observable<clsGlobalAPI>

    @Headers("Content-Type: application/json")
    @POST("${Constants.ConectionTag.basePath}logOutMobile")
    fun logoutMobile(@Body clsGlobalAPI: clsGlobalAPI): Observable<clsGlobalAPI>

}