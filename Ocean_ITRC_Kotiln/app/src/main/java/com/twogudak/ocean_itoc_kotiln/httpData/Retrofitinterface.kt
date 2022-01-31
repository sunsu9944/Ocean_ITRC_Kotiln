package com.twogudak.ocean_itoc_kotiln.httpData

import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchContinueDTO
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchResultsDTO
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.userDTO
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface Retrofitinterface {
    @POST("/members/android/memberALL")
    fun getMembers(): retrofit2.Call<MemberDTO>

    @GET("/research/android/fields")
    fun getResearchContinue(): retrofit2.Call<List<ResearchContinueDTO>>

    @GET("/research/android/results")
    fun getResearchResults(@Query("classify") querys: String): Call<List<ResearchResultsDTO>>

    @POST("/auth/android/login")
    fun userLogin(@Body loginInfo : HashMap<String, String>):Call<userDTO>

}