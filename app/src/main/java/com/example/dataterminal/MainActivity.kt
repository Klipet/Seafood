package com.example.dataterminal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appCounter = AppCounter(applicationContext)
        appCounter.incrementLaunchCount()

        println(appCounter.getLaunchCountState())


        if (appCounter.getLaunchCountState() > 6){
            Handler().postDelayed({
                val intent = Intent(this, LoginRegister::class.java)
                startActivity(intent)
                finish() // Опционально, если хотите закрыть текущую активность после открытия второй активности
            }, 2000)

        }
        else{
            Handler().postDelayed({
                val intent = Intent(this, SplashInfo::class.java)
                startActivity(intent)
                finish() // Опционально, если хотите закрыть текущую активность после открытия второй активности
            }, 2000)

        }

    }




}
    class AppCounter(context: Context) {

        private val sharedPrefs: SharedPreferences = context.getSharedPreferences(
            "app_counter", Context.MODE_PRIVATE
        )

        private val launchCountKey = "launch_count"

        var launchCount: Int
            get() = sharedPrefs.getInt(launchCountKey, 0)
            set(value) = sharedPrefs.edit().putInt(launchCountKey, value).apply()

        fun incrementLaunchCount() {
            launchCount++
            saveLaunchCount()
        }

        fun getLaunchCountState() = launchCount

        private fun saveLaunchCount() {
            sharedPrefs.edit().putInt(launchCountKey, launchCount).apply()
        }
    }


