package com.example.hw10_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hw10_3.Storage.arrayOfItems
import com.example.hw10_3.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem as MenuItem1

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pref2 = getSharedPreferences("share2", Context.MODE_PRIVATE)
        if(!pref2.getString("theme", "").isNullOrBlank()){
            if (pref2.getString("theme", "")=="1"){
                setTheme(R.style.Theme1)
            }else if (pref2.getString("theme", "")=="2"){
                setTheme(R.style.Theme2)
            }
        }

        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        //appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,
            R.id.profileFragment,R.id.settingFragment), binding.drawerLayout)


        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }




    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
     fun onNavigationItemSelected( item: MenuItem1){
        if (item.itemId==R.id.exit){
            finish()
        }
     }

}



