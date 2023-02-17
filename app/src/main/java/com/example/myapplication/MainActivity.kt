package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* the following play a music background*/
        val mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.start()
        mediaPlayer.isLooping = true


    }

}