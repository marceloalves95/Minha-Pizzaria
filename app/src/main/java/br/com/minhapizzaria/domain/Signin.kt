package br.com.minhapizzaria.domain

import com.google.gson.annotations.SerializedName

data class Signin(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)