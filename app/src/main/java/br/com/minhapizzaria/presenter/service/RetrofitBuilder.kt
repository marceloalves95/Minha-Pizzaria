package br.com.minhapizzaria.presenter.service

import br.com.minhapizzaria.presenter.api.PizzariaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by RubioAlves on 12/04/2021
 */
object RetrofitBuilder {

    private const val BASE_URL = "https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/v1/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
    }

    val pizzariaApi: PizzariaApi = getRetrofit().create(PizzariaApi::class.java)
}