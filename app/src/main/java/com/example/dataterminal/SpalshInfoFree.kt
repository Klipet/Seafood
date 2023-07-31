package com.example.dataterminal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dataterminal.databinding.ActivitySpalshInfoFreeBinding
import com.example.dataterminal.databinding.ActivitySplashInfoBinding

class SpalshInfoFree : AppCompatActivity() {
    private lateinit var binding: ActivitySpalshInfoFreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalshInfoFreeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_spalsh_info_free)
        var view = binding.root
        setContentView(view)


        binding.btNextSpalshFree.setOnClickListener {
            val intent = Intent(this, LoginRegister::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvSkipSplasFree.setOnClickListener {
            val intent = Intent(this, LoginRegister::class.java)
            startActivity(intent)
            finish()
        }
        binding.imBeakSplashFree.setOnClickListener {
            val intent = Intent(this, SplashInfoTwo::class.java)
            startActivity(intent)
            finish()
        }


    }

}