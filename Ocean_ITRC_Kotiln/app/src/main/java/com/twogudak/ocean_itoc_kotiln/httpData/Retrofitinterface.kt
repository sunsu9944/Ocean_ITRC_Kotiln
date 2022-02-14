package com.twogudak.ocean_itoc_kotiln.httpData

import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.*
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO
import retrofit2.Call
import retrofit2.http.*


interface Retrofitinterface {
    @POST("/members/android/memberALL")
    fun getMembers( @Header("token") token: String?): retrofit2.Call<MemberDTO>

    @GET("/research/android/fields")
    fun getResearchContinue(): retrofit2.Call<List<ResearchContinueDTO>>

    @GET("/research/android/results")
    fun getResearchResults(@Query("classify") querys: String): Call<List<ResearchResultsDTO>>

    @POST("/auth/android/login")
    fun userLogin(@Body loginInfo : HashMap<String, String>):Call<userDTO>

    @POST("/auth/android/revise")
    fun revise(@Header("token") token: String?, @Body reviseinfo : HashMap<String, String?>):Call<reviseDTO>

    @GET("/auth/logout")
    fun logout(@Header("token") token: String?): Call<userDTO>

    @POST("/auth/android/revise_check")
    fun checkPW(@Header("token") token:String?, @Body PassWard : HashMap<String,String>) : Call<CheckPWDTO>

    @GET("/app")
    fun main(@Header("token") token: String?): Call<mainDTO>

    @GET("/gallery/app")
    fun getgallery(@Header("token") token: String?): Call<GalleryDTO>

    @GET("board/app-notice")
    fun getNotice() : Call<NoticeDTO>

}