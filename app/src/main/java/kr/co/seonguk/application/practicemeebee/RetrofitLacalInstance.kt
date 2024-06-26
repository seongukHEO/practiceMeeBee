package kr.co.seonguk.application.practicemeebee

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitLocalInstance {
    const val LOCAL_API_KEY = "Qahe3YsG5DEh1NrEibW9IUu4P/yYTgk4lBC6o0giu4nI1UjwSA3iTZXm4OcQ4Z/Q1ALRTLaKfZ6DsMEg+XsoqA=="

    private fun httpLoggingInterceptor():Interceptor{
        return HttpLoggingInterceptor{message -> Log.e("MyOkHttpLocal : ", message + "")}
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor())
            .build()
    }

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .baseUrl("http://apis.data.go.kr/1192000/service/OceansBeachInfoService1/")
            .build()
    }

    val retrofitService: LocalRetrofitService by lazy {
        retrofit.create(LocalRetrofitService::class.java)
    }
}
