package com.twogudak.ocean_itoc_kotiln.httpData

import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchContinueDTO
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO
import retrofit2.http.GET
import retrofit2.http.POST


interface Retrofitinterface {
    @POST("/members/android/memberALL")
    fun getMembers(): retrofit2.Call<MemberDTO>

    @GET("/research/android/fields")
    fun getResearchContinue(): retrofit2.Call<List<ResearchContinueDTO>>
}