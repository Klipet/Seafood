package com.example.dataterminal

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.dataterminal.adapters.VpAdapter
import com.example.dataterminal.databinding.ActivityLoginRegisterBinding
import com.google.android.material.tabs.TabLayoutMediator

class LoginRegister : AppCompatActivity() {
    private val tList = listOf(
        "Login",
        "Register"
    )

    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        val view = binding.root
        setContentView(view)

        binding.vp.adapter = VpAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.vp){
            t,p -> t.text = tList[p]
        }.attach()
    }


}