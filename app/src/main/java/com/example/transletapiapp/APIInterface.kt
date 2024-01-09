package com.example.transletapiapp

import android.appwidget.AppWidgetHost
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.POST

interface APIInterface {

    @POST("translate")
    fun TranslateApi(

        @Header("X-RapidAPI-Key") key : String,
        @Header("X-RapidAPI-Host") host: String,
      @Field("source_language") source_language:String, @Field("target_language") target_language:String, @Field("text") text:String
    ):Call<TranslateModel>

}