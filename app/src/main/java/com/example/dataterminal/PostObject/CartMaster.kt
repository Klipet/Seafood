package com.example.dataterminal.PostObject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dataterminal.data.Product
import com.example.dataterminal.data.ProductX

object CartMaster {
    private val cardItems: MutableMap<String, Int> = mutableMapOf()
    private val _cardLiveData = MutableLiveData<Map<String, Int>>()
    val cardLiveData: LiveData<Map<String, Int>> = _cardLiveData

    fun addToCard(product: ProductX){
        val quantety = cardItems[product.id.toString()] ?: 0
        cardItems[product.id.toString()] = quantety +1
        _cardLiveData.value = cardItems
    }
}