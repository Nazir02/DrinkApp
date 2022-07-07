package com.example.drinkapp.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.view.ARG
import com.example.drinkapp.view.DrinkFragment

class DrinkAdapter(fragment:FragmentActivity, users: List<DbModel>):FragmentStateAdapter(fragment) {
    private var listDrink= users

    override fun createFragment(position: Int): Fragment {
        val fragment= DrinkFragment()
        fragment.arguments= Bundle().apply {
            putString(ARG,listDrink[position].strDrink)
        }
        return fragment
    }
    override fun getItemCount(): Int { return listDrink.size }
}