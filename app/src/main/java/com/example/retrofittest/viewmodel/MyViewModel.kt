package com.example.retrofittest.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofittest.WeatherData
import com.example.retrofittest.model.WeathersApiService
import retrofit2.Call
import retrofit2.Response

class MyViewModel : ViewModel() {
    private val weathersApiService = WeathersApiService()
    private val api = weathersApiService.getApi()

    var weatherLiveData = MutableLiveData<WeatherData>()

    fun fetchFromRemote(): MutableLiveData<WeatherData> {
        api.getWeathers().enqueue(object : retrofit2.Callback<WeatherData> {
            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Log.d("error","error :unknown")

            }

            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.isSuccessful) {
                    weatherLiveData.value = response.body()
                }
                else{
                    var errorCode:String
                    when (response.code()) {
                        404 -> Log.d("error","error :404")
                        500 -> Log.d("error","error :500")
                        else -> { // 注意这个块
                            Log.d("error","error :unknown")

                        }
                    }
                }
            }
        })
        return weatherLiveData
    }


}