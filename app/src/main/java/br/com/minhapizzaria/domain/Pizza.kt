package br.com.minhapizzaria.domain

import com.google.gson.annotations.SerializedName

data class Pizza(

    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("priceG")
    val priceG: Float,
    @SerializedName("priceM")
    val priceM: Float,
    @SerializedName("priceP")
    val priceP: Float,
    @SerializedName("rating")
    val rating: Float
)