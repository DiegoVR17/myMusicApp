package com.example.mymusicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mymusicapp.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var artistBinding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        artistBinding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(artistBinding.root)

        artistBinding.buttonSearchSong.setOnClickListener {
            val artist = artistBinding.TextInputEditTextArtist.text.toString()
            if(artist != null){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("artist", artist)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Campo de artista vacio",Toast.LENGTH_SHORT).show()
            }
        }
    }
}