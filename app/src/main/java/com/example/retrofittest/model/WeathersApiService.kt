package com.example.retrofittest.model

import com.example.retrofittest.WeatherData
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory

class WeathersApiService  {
    private  val URL="https://opendata.cwb.gov.tw/"
    private val api=Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeathersApi::class.java)

     fun getApi():WeathersApi{
        return api
    }



}