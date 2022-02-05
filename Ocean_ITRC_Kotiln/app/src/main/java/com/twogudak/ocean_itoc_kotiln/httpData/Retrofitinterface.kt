package com.twogudak.ocean_itoc_kotiln.httpData

import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.*
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO
import retrofit2.Call
import retrofit2.http.*


interface Retrofitinterface {
    @POST("/members/android/memberALL")
    fun getMembers( @Header("user") token: String?): retrofit2.Call<MemberDTO>

    @GET("/research/android/fields")
    fun getResearchContinue(): retrofit2.Call<List<ResearchContinueDTO>>

    @GET("/research/android/results")
    fun getResearchResults(@Query("classify") querys: String): Call<List<ResearchResultsDTO>>

    @POST("/auth/android/login")
    fun userLogin(@Body loginInfo : HashMap<String, String>):Call<userDTO>

    @GET("/auth/logout")
    fun logout(@Header("user") token: String?): Call<userDTO>

    @GET("/app")
    fun main(@Header("user") token: String?): Call<mainDTO>

    @GET("/gallery/app")
    fun getgallery(@Header("user") token: String?): Call<GalleryDTO>

}