package br.com.minhapizzaria.presenter.interfaces

import br.com.minhapizzaria.domain.Pizza
import br.com.minhapizzaria.domain.Signin
import br.com.minhapizzaria.domain.ValidadorLogin
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by RubioAlves on 11/04/2021
 */
interface PizzariaApi {

    @GET("pizza")
    fun getPizza(): Call<MutableList<Pizza>>

    @POST("signin")
    fun getLogin(@Body validadorLogin: ValidadorLogin):Call<Signin>

}