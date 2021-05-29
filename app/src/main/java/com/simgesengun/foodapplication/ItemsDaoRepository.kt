package com.simgesengun.foodapplication

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsDaoRepository {

    private val itemsList:MutableLiveData<List<Item>>
    private val idaoi:ItemsDaoInterface

    init {
        idaoi = ApiUtils.getItemsDaoInterface()
        itemsList= MutableLiveData()
    }

    fun getItems():MutableLiveData<List<Item>>{
        return itemsList
    }

    fun showAllItems(){
        idaoi.allItems().enqueue(object: Callback<ItemResponse> {

            override fun onResponse (call: Call<ItemResponse>?, response: Response<ItemResponse>){
                val itemList = response.body().yemekler

               itemsList.value = itemList


            }

            override fun onFailure(call: Call<ItemResponse>?, t: Throwable?) {
            }
        })
    }
}