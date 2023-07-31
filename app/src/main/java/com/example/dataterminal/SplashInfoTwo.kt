package com.example.dataterminal

import android.app.slice.Slice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dataterminal.databinding.ActivitySpalshInfoFreeBinding
import com.example.dataterminal.databinding.ActivitySplashInfoTwoBinding

class SplashInfoTwo : AppCompatActivity() {
    private lateinit var binding: ActivitySplashInfoTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashInfoTwoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash_info_two)
        var view = binding.root
        setContentView(view)

        binding.imBeakSplashTwoo.setOnClickListener {
            val intent = Intent(this, SplashInfo::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvSkipSplasTwoo.setOnClickListener {
            val intent = Intent(this, LoginRegister::class.java)
            startActivity(intent)
            finish()
        }
        binding.btNextTwoo.setOnClickListener {
            val intent = Intent(this, SpalshInfoFree::class.java)
            startActivity(intent)
            finish()
        }

    }

}