package br.com.minhapizzaria.presenter.service

import br.com.minhapizzaria.presenter.interfaces.PizzariaApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by RubioAlves on 12/04/2021
 */
class LoginService {

    private val retrofit by lazy {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getLoginApi(): PizzariaApi {
        return retrofit.create(PizzariaApi::class.java)
    }

    companion object {

        private const val BASE_URL = "https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/v1/"

        var loginService: LoginService? = null

        @get:Synchronized
        val instance: LoginService?
            get() {
                if (loginService == null) {

                    loginService = LoginService()

                }
                return loginService
            }

    }

}