package kr.co.seonguk.application.practicemeebee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofitWork()
    }

    private fun retrofitWork(){
        val service = RetrofitInstance.retrofitService
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        val currentTime = Date()
        val formattedDate = dateFormat.format(currentTime)

        service.getShortWeather(RetrofitInstance.API_KEY, 1,10, "JSON", formattedDate, 1100, 1)
            .enqueue(object : retrofit2.Callback<ShortWeatherApi>{
                override fun onResponse(p0: Call<ShortWeatherApi>, p1: Response<ShortWeatherApi>) {
                    val result = p1.body()?.response?.body
                    Log.d("test1234", "${result}")
                }

                override fun onFailure(p0: Call<ShortWeatherApi>, p1: Throwable) {
                    Log.d("test1234", "${p1}")
                }
            })
    }
}