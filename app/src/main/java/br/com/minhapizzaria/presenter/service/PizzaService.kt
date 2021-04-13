package br.com.minhapizzaria.presenter.service

import br.com.minhapizzaria.presenter.api.PizzariaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by RubioAlves on 09/04/2021
 */
class PizzaService {

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getPizzaApi(): PizzariaApi {
        return retrofit.create(PizzariaApi::class.java)
    }

    companion object {

        private const val BASE_URL = "https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/v1/"

        var pizzaService: PizzaService? = null

        @get:Synchronized
        val instance: PizzaService?
            get() {
                if (pizzaService == null) {

                    pizzaService = PizzaService()

                }
                return pizzaService
            }

    }


}