package com.example.dataterminal.adapters

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dataterminal.data.Product

class TabsAdapter(fm: FragmentActivity, private val list: List<Fragment>): FragmentStateAdapter(fm){
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }


}