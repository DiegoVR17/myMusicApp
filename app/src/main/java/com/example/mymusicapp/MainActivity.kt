package com.example.mymusicapp

import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusicapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        if (intent.hasExtra("artist")) {
            val artist = intent.getStringExtra("artist")
            if (artist != null) {
                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiInterface::class.java)

                val retrofitData = retrofitBuilder.getData(artist)

                retrofitData.enqueue(object : Callback<MyData?>{
                    override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                        val dataList = response.body()?.data!!

                        mainBinding.RecyclerView.adapter = MyAdapter(this@MainActivity,dataList,onItemClicked = { onItemSongClicked(it)})
                        mainBinding.RecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    }

                    override fun onFailure(call: Call<MyData?>, t: Throwable) {
                        Toast.makeText(this@MainActivity,"error",Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
        else{
            Toast.makeText(this@MainActivity,"error_artist",Toast.LENGTH_SHORT).show()
        }

    }

    private fun onItemSongClicked(data: Data?) {
    }
}
