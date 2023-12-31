package com.example.dataterminal.fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.lifecycleScope
import com.example.dataterminal.Home
import com.example.dataterminal.LoginRegister
import com.example.dataterminal.R
import com.example.dataterminal.data.AutRequest
import com.example.dataterminal.data.User
import com.example.dataterminal.databinding.LoginBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


@Suppress("SENSELESS_COMPARISON", "NAME_SHADOWING")
class Login : Fragment() {
    private lateinit var api: RetrofitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.login, container, false)

        val btLogin = v.findViewById<Button>(R.id.btLogin)
        val login = v.findViewById<EditText>(R.id.edUserName)
        val password = v.findViewById<EditText>(R.id.edTexPassword)
     try {

         btLogin.setOnClickListener {
       //      logIn(login.toString(),
       //          password.toString())
             val intent = Intent(activity, Home::class.java)
             startActivity(intent)
         }
     } catch (e: Exception){
         showToast( "Error: ${e.message}", Toast.LENGTH_LONG)
     }
        return v

    }

    fun logIn(userName: String, password: String){

        try {
            lifecycleScope.launch(Dispatchers.IO) {
                var response = RetrofitApi.api.auth(
                    AutRequest(
                        userName,
                        password
                    )
                )
                if (response.token != null) {
                    val userName = response.firstName.toString()
                    val image = response.image.toString()
                    val intent = Intent(activity, Home::class.java)
                    intent.putExtra("image", image.toString())
                    intent.putExtra("user", userName.toString())
                    startActivity(intent)
                } else {
                    Log.e(TAG, "Ошибка запроса POST: ${response}")
                }
            }
        }catch (e: Exception){
            showToast( "Error: ${e.message}", Toast.LENGTH_LONG)
        }

    }
    private fun showToast(message: String, duration: Int) {
        context?.let {
            Toast.makeText(it, message, duration).show()
        }
    }
}
