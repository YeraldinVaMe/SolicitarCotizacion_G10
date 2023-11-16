package com.example.solicitarcotizacion.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.27:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInstance by lazy {
        retrofit.create(ApiService::class.java)
    }
}