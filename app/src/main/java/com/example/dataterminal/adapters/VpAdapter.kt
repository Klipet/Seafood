package com.example.dataterminal.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dataterminal.fragment.Login
import com.example.dataterminal.fragment.Register

class VpAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2

    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Login()
            1 -> Register()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}