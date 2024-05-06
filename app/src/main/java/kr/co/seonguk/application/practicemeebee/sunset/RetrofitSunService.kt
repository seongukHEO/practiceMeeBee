package kr.co.seonguk.application.practicemeebee.sunset

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitSunService {

    @GET("getLCRiseSetInfo")
    fun getSunset(
        @Query("longitude") longitude:Int,
        @Query("latitude") latitude:Int,
        @Query("locdate") locdate: String,
        @Query("dnYn") dnYn:String,
        @Query("ServiceKey") ServiceKey: String
    ): Call<SunsetApi>
}