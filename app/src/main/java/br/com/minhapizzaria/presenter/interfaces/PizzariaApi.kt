package br.com.minhapizzaria.presenter.interfaces

import androidx.lifecycle.MutableLiveData
import br.com.minhapizzaria.domain.Pizza
import br.com.minhapizzaria.domain.Signin
import br.com.minhapizzaria.domain.Teste
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by RubioAlves on 11/04/2021
 */
interface PizzariaApi {

    @GET("pizza")
    fun getPizza(): Call<MutableList<Pizza>>

    @POST("signin")
    fun getLogin(@Body teste: Teste):Call<Signin>

}