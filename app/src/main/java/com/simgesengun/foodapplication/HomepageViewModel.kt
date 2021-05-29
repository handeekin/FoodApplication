package com.simgesengun.foodapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomepageViewModel: ViewModel() {

    private val iDaoR = ItemsDaoRepository()

    var itemsList = MutableLiveData<List<Item>>()

    init{
        getItems()
        itemsList = iDaoR.getItems()
    }

    fun getItems(){
        iDaoR.getItems()
    }
}