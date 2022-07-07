package com.example.drinkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.view.CategoryFragment
import com.example.drinkapp.view.FavoriteFragment
import com.example.drinkapp.view.HistoryFragment
import com.example.drinkapp.view.SettingsFragment
import com.example.drinkapp.vm.CachViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemReselectedListener,
    NavigationBarView.OnItemSelectedListener {
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener(this)
        setSupportActionBar(findViewById(R.id.toolBar))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.category_menu ->
                loadFragment(CategoryFragment())
            R.id.history_menu ->
                loadFragment(HistoryFragment())
            R.id.favorite_menu ->
                loadFragment(FavoriteFragment())
            R.id.settings_menu ->
                loadFragment(SettingsFragment())
        }
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        TODO("Not yet implemented")
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }

}
 


