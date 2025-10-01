package com.example.musicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button:ImageButton = findViewById(R.id.play)
        button.setOnClickListener {
            isPlaying = !isPlaying
            if (isPlaying) {
                button.setImageResource(android.R.drawable.ic_media_pause)
            } else {
                button.setImageResource(android.R.drawable.ic_media_play)
            }
        }

        val seekBarBol = findViewById<SeekBar>(R.id.seekBarBolumena)
        seekBarBol.setMax(100)
        seekBarBol.setProgress(70)

        val seekBarAb = findViewById<SeekBar>(R.id.seekBarAbestia)
        seekBarAb.setMax(100)
        seekBarAb.setProgress(25)
    }
}