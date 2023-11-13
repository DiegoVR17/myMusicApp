package com.example.mymusicapp

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiInterface {

    @Headers("X-RapidAPI-Key: fd3eccb11dmsh8098a01810e329dp128767jsn13216b453aea",
    "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String) :  retrofit2.Call<MyData>


}