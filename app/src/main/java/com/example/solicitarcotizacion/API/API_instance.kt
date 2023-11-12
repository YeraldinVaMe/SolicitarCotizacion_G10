package com.example.solicitarcotizacion.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API_instance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://gn892wjr-5000.brs.devtunnels.ms/") //cambiar por el url que tu generas
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val _instance by lazy {
        retrofit.create(API_service::class.java)
    }
}