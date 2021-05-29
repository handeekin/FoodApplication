package com.simgesengun.foodapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var idaoi: ItemsDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idaoi=ApiUtils.getItemsDaoInterface()

        showItems()


        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController)

       // var url = "http://kasimadalan.pe.hu/yemekresimler/"

       // Picasso.get().load(url).into()

    }

    fun showItems(){
        idaoi.allItems().enqueue(object : Callback<ItemResponse> {
            override fun onResponse(call: Call<ItemResponse>?, response: Response<ItemResponse>?) {

            }

            override fun onFailure(call: Call<ItemResponse>?, t: Throwable?) {

            }
        } )
    }
}