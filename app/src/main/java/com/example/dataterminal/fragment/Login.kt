package com.example.dataterminal.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dataterminal.LoginRegister
import com.example.dataterminal.data.AutRequest
import com.example.dataterminal.data.User
import com.example.dataterminal.databinding.LoginBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Suppress("UNREACHABLE_CODE")
class Login : Fragment() {
     private var _binding: LoginBinding? = null
     private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        binding.btLogin.setOnClickListener {
            val retrofitApi = RetrofitApi.api
            val login = binding.edUserName.text.toString()
            val password = binding.edTexPassword.text.toString()

            val response = retrofitApi.auth(
                AutRequest(
                    login,
                    password
                )
            )
                val intent = Intent(activity, LoginRegister::class.java)
                intent.putExtra("im", response.image)
                intent.putExtra("name", response.firstName)
                startActivity(intent)

        }

    }
}