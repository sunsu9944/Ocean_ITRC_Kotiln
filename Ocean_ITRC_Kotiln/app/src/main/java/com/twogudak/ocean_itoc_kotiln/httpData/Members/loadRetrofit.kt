package com.twogudak.ocean_itoc_kotiln.httpData.Members

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object loadRetrofit {

    private val retrofitClient : Retrofit.Builder by  lazy {
        Retrofit.Builder()
            .baseUrl(DOMAIN.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
    }
    val OPEN_SERVICE: Retrofitinterface by lazy {
        retrofitClient.build().create(Retrofitinterface::class.java)!!
    }
}