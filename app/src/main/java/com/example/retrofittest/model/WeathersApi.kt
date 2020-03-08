package com.example.retrofittest.model

import com.example.retrofittest.WeatherData
import retrofit2.Call
import retrofit2.http.GET


interface  WeathersApi{
    @GET("/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-E65C7A1E-4F20-43B3-A3BB-2BD819828F7A&locationName=%E8%87%BA%E5%8C%97%E5%B8%82")
    fun getWeathers(): Call<WeatherData>
}

