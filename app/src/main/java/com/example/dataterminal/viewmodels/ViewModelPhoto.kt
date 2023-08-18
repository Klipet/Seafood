package com.example.dataterminal.viewmodels

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.retrofit_api.RetrofitApi
import kotlinx.coroutines.launch
import okhttp3.RequestBody.Companion.gzip
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse
import javax.security.auth.callback.Callback

class ViewModelPhoto: ViewModel() {
    private val _image = MutableLiveData<List<String>>()
    val images: LiveData<List<String>> = _image
    val intent = Intent()
    init {
        viewModelScope.launch {
            val imageList = RetrofitApi.api.getProduct(intent.getStringExtra("code").toString())
       //     _image.value = imageList.body()?.images

        }
    }
}