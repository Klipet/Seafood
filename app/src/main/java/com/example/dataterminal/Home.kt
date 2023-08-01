package com.example.dataterminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dataterminal.databinding.ActivityHomeBinding
import com.squareup.picasso.Picasso

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        setContentView(binding.root)

        val imgInfo = intent.getStringExtra("im")
        Picasso.get().load(imgInfo).into(binding.imPhoto)
        binding.tvHi.text = intent.getStringExtra("name")

    }
}