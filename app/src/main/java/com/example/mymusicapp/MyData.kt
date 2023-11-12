package com.example.mymusicapp


import com.google.gson.annotations.SerializedName

data class MyData(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("next")
    val next: String,
    @SerializedName("total")
    val total: Int
)