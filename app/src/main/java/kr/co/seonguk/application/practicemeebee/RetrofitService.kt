package kr.co.seonguk.application.practicemeebee

import kr.co.seonguk.application.practicemeebee.sunset.SunsetApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat

interface RetrofitService {
    @GET("getUltraSrtFcstBeach")
    fun getShortWeather(
        @Query("serviceKey") SERVICEKEY: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("dataType") dataType: String,
        @Query("base_date") baseDate: SimpleDateFormat,
        @Query("base_time") baseTime: Int,
        @Query("beach_num") beachNum: Int
    ) : Call<ShortWeatherApi>

   @GET("getTwBuoyBeach")
   fun getWaterTemp(
       @Query("serviceKey") SERVICEKEY: String,
       @Query("numOfRows") numOfRows: Int,
       @Query("pageNo") pageNo: Int,
       @Query("dataType") dataType: String,
       @Query("beach_num") beach_num: Int,
       @Query("searchTime") searchTime: Long
   ) : Call<WaterTempApi>




}