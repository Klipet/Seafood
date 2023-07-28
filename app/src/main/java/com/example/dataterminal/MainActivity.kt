package com.example.dataterminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dataterminal.fragment.StartPageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, StartPageFragment())
            .commit()
    }
}