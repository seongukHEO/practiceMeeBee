package kr.co.seonguk.application.practicemeebee.sunset

import android.util.Log
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import kr.co.seonguk.application.practicemeebee.RetrofitInstance
import kr.co.seonguk.application.practicemeebee.RetrofitLocalInstance
import kr.co.seonguk.application.practicemeebee.RetrofitService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object RetrofitSunsetInstance {

    const val LOCAL_KEY = "내 키 값 ㅎㅎ"

    private fun httpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor{message -> Log.e("MyOkHttpSunset : ", message + "")}
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor())
            .build()
    }

    private val getInstance: Retrofit by lazy {

        val parser = TikXml.Builder().exceptionOnUnreadXml(false).build()

        Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/B090041/openapi/service/RiseSetInfoService/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(TikXmlConverterFactory.create(parser))
            .client(client)
            .build()
    }

    val retrofitService: RetrofitSunService by lazy {
        getInstance.create(RetrofitSunService::class.java)
    }
}