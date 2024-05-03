package kr.co.seonguk.application.practicemeebee

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("response")
    fun getShortWeather(
        @Query("serviceKey") SERVICEKEY: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("dataType") dataType: String,
        @Query("base_date") baseDate: String,
        @Query("base_time") baseTime: Int,
        @Query("beach_num") beachNum: Int
    ) : Call<ShortWeatherApi>
}