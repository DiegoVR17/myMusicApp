package com.example.mymusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymusicapp.databinding.ActivityDetailSongBinding
import com.example.mymusicapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class DetailSongActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailSongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailSongBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val cover = intent.getStringExtra("cover")
        val title = intent.getStringExtra("title")
        val nameSinger = intent.getStringExtra("nameSinger")
        val rank = intent.getIntExtra("rank",0)

        with(detailBinding){
            Picasso.get().load(cover).into(ImageViewPhotoSinger)
            textViewAlbum.text = title.toString()
            textViewSinger.text = nameSinger.toString()
            textViewTrackList.text = rank.toString()
        }
    }
}