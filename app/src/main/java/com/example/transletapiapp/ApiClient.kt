package com.example.transletapiapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{

        var retrofit : Retrofit?= null
        val BaseUrl = "https://text-translator2.p.rapidapi.com/"

        fun getApiClient(): Retrofit?{

            if (retrofit==null){
                retrofit = Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(
                    GsonConverterFactory.create()).build()

            }

            return retrofit

        }
    }
}