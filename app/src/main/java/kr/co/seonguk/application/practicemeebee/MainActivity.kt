package kr.co.seonguk.application.practicemeebee

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import kr.co.seonguk.application.practicemeebee.databinding.ActivityMainBinding
import kr.co.seonguk.application.practicemeebee.sunset.RetrofitSunsetInstance
import kr.co.seonguk.application.practicemeebee.sunset.SunsetApi
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date



class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitWork()
        retrofitWaterTemp()
        settingEvent()
        getSunSetDataByRetrofit()
    }

    private fun retrofitWork(){
        val service = RetrofitInstance.retrofitService
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        val currentTime = Date()
        val formattedDate = dateFormat.format(currentTime)

        service.getShortWeather(RetrofitInstance.API_KEY, 10,1, "JSON", dateFormat, 1000, 1)
            .enqueue(object : retrofit2.Callback<ShortWeatherApi>{
                override fun onResponse(p0: Call<ShortWeatherApi>, p1: Response<ShortWeatherApi>) {
                    val result = p1.body()?.response?.body

                    //Log.d("test1234", "${result?.items}")




                }

                override fun onFailure(p0: Call<ShortWeatherApi>, p1: Throwable) {
                   // Log.e("test1234", "$p1")
                }
            })
    }

    private fun retrofitWaterTemp(){
        val service = RetrofitInstance.retrofitService
        service.getWaterTemp(RetrofitInstance.API_KEY, 10, 1, "json", 1, 202405061000)
            .enqueue(object : retrofit2.Callback<WaterTempApi>{
                override fun onResponse(p0: Call<WaterTempApi>, p1: Response<WaterTempApi>) {
                    val result = p1.body()?.response?.body
                    binding.textViewWaterTemp.text = "수온 : ${result?.items?.item?.map { it?.tw }}도"
                    //Log.d("test1234", "${result}")
                }

                override fun onFailure(p0: Call<WaterTempApi>, p1: Throwable) {
                    //Log.e("test1234", "${p1}")
                }

            })
    }

    private fun settingEvent(){
        with(binding){
            val service = RetrofitLocalInstance.retrofitService

            buttonJeju.setOnClickListener {
                service.getLocalData(RetrofitLocalInstance.LOCAL_API_KEY, 1, 10, Util.JEJU.str, "json")
                    .enqueue(object :retrofit2.Callback<LocalOceanApi>{
                        override fun onResponse(
                            p0: Call<LocalOceanApi>,
                            p1: Response<LocalOceanApi>
                        ) {
                            val result = p1.body()?.getOceansBeachInfo



                            textViewJeju.text = "제주의 해수욕장 갯수 : ${result?.totalCount.toString()}"
                            //Log.d("test1234", "${result}")
                        }

                        override fun onFailure(p0: Call<LocalOceanApi>, p1: Throwable) {
                            //Log.d("test1234", "${p1}")
                        }

                    })
            }
            button2Busan.setOnClickListener {
                service.getLocalData(RetrofitLocalInstance.LOCAL_API_KEY, 1, 10, Util.BUSAN.str, "json")
                    .enqueue(object :retrofit2.Callback<LocalOceanApi>{
                        override fun onResponse(
                            p0: Call<LocalOceanApi>,
                            p1: Response<LocalOceanApi>
                        ) {
                            val result = p1.body()?.getOceansBeachInfo
                            textViewBusan.text = "부산의 해수욕장 갯수 : ${result?.totalCount.toString()}"
                        }

                        override fun onFailure(p0: Call<LocalOceanApi>, p1: Throwable) {

                        }

                    })

            }
            buttonInchen.setOnClickListener {
                service.getLocalData(RetrofitLocalInstance.LOCAL_API_KEY, 1, 10, Util.INCHEON.str, "json")
                    .enqueue(object :retrofit2.Callback<LocalOceanApi>{
                        override fun onResponse(
                            p0: Call<LocalOceanApi>,
                            p1: Response<LocalOceanApi>
                        ) {
                            val result = p1.body()?.getOceansBeachInfo
                            textViewBusan.text = "인천의 해수욕장 갯수 : ${result?.totalCount.toString()}"
                        }

                        override fun onFailure(p0: Call<LocalOceanApi>, p1: Throwable) {

                        }

                    })
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getSunSetDataByRetrofit(){
        val service = RetrofitSunsetInstance.retrofitService
        val currentDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)

        //Log.e("test1234", dateFormat.toString())

        service.getSunset(12800, 3613, currentDate,"N", RetrofitSunsetInstance.LOCAL_KEY)
            .enqueue(object : retrofit2.Callback<SunsetApi>{
                override fun onResponse(p0: Call<SunsetApi>, p1: Response<SunsetApi>) {
                    val result = p1.body()?.body?.items?.item

                    val sunriseList = result?.map { it.sunrise }
                    val sunriseString = sunriseList?.joinToString(separator = " ")

                    binding.textViewPlace.text = result?.map { it.location }?.joinToString(separator = " ")
                    binding.textViewSunrise.text = "일출 : ${sunriseString}"
                    binding.textViewSunset.text = "일몰 : ${result?.map { it.sunset }?.joinToString(separator = " ")}"

                }

                override fun onFailure(p0: Call<SunsetApi>, p1: Throwable) {
                    Log.e("test1234", "${p1}")
                }

            })
    }
}