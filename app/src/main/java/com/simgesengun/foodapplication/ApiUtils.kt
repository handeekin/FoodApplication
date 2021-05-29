package com.simgesengun.foodapplication

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getItemsDaoInterface() : ItemsDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(ItemsDaoInterface ::class.java)
        }
    }
}