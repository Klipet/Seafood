package com.example.dataterminal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import com.example.dataterminal.databinding.ActivitySplashInfoBinding

class SplashInfo : AppCompatActivity() {

    private lateinit var binding: ActivitySplashInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashInfoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash_info)
        val view = binding.root
        setContentView(view)


        binding.tvSkipSplas.setOnClickListener {
            val intent = Intent(this, LoginRegister::class.java)
            startActivity(intent)
            finish()
        }
        binding.btNext.setOnClickListener {
            val intent = Intent(this, SplashInfoTwo::class.java)
            startActivity(intent)
            finish()
        }


    }


}