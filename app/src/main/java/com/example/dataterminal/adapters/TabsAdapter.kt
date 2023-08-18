package com.example.dataterminal.adapters

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dataterminal.data.CategoryX
import com.example.dataterminal.data.Product
import com.example.dataterminal.fragment.ProductiaFragment

class TabsAdapter(fm: FragmentActivity, private val list: List<String>): FragmentStateAdapter(fm){
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val category = list[position]
        return ProductiaFragment.newInstance(category)
    }


}