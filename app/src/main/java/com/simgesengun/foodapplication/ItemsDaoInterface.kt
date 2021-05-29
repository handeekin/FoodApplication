package com.simgesengun.foodapplication

import retrofit2.Call
import retrofit2.http.GET

interface ItemsDaoInterface {
    @GET("yemekler/tum_yemekler.php")
    fun allItems(): Call<ItemResponse>
}