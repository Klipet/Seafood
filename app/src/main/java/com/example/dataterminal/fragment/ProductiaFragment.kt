package com.example.dataterminal.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dataterminal.InfoFood
import com.example.dataterminal.R
import com.example.dataterminal.adapters.ProductAdapter
import com.example.dataterminal.databinding.FragmentProductiaBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductiaFragment : Fragment() {
    private lateinit var binding: FragmentProductiaBinding
    private lateinit var adapter: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentProductiaBinding.inflate(inflater, container, false)
        val view = binding.root

        init()

        return view

    }
    companion object{
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): ProductiaFragment {
            val fragment = ProductiaFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORY, category)
            fragment.arguments = args
            return fragment
        }
    }
    fun init(){

        adapter = ProductAdapter{ product ->

            val intent = Intent(context, InfoFood::class.java)
            println(product.id)
            intent.putExtra("code", product.id.toString())
            startActivity(intent)
        }
        binding.rcViewProductia.layoutManager = GridLayoutManager(context, 2)
        binding.rcViewProductia.adapter = adapter
        CoroutineScope(Dispatchers.Main).launch {
            val list = RetrofitApi.api.getAllProduct()
            adapter.submitList(list.products)
        }
    }




}