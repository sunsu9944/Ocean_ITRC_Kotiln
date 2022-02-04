package com.twogudak.ocean_itoc_kotiln.httpData

import android.content.Context
import com.twogudak.ocean_itoc_kotiln.UserData
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

object loadRetrofit {

    private val retrofitClient : Retrofit.Builder by  lazy {
        Retrofit.Builder()
            .baseUrl(DOMAIN.DOMAIN)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    }




    val OPEN_SERVICE: Retrofitinterface by lazy {
        retrofitClient.build().create(Retrofitinterface::class.java)!!
    }


}