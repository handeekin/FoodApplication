package com.simgesengun.foodapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItemResponse (
    @SerializedName("yemekler")
    @Expose
    var yemekler: List<Item>,
    @SerializedName("success" )
    @Expose
    var success: Int ) {
}