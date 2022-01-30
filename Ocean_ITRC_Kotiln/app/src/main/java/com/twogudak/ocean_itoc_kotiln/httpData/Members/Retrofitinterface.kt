package com.twogudak.ocean_itoc_kotiln.httpData.Members

import retrofit2.http.POST


interface Retrofitinterface {
    @POST("/members/android/memberALL")
    fun getMembers(): retrofit2.Call<MemberDTO>
}