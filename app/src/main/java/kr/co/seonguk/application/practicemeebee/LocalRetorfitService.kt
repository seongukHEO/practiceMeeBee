package kr.co.seonguk.application.practicemeebee

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocalRetrofitService {
    @GET("getOceansBeachInfo1")
    fun getLocalData(
        @Query("ServiceKey") ServiceKey: String,
        @Query("pageNo") pageNo:Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("SIDO_NM") SIDO_NM:String,
        @Query("resultType") resultType:String
    ):Call<LocalOceanApi>
}