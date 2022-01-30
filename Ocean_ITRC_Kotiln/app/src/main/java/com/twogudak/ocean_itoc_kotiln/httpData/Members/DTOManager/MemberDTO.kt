package com.twogudak.ocean_itoc_kotiln.httpData.Members

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class MemberDTO(
    @SerializedName("result")
    var memberlist:ArrayList<Memberdetail>)

data class Memberdetail(
    @SerializedName("name_ko")
    var name_ko: String,
    @SerializedName("department_ko")
    var department_ko: String,
    @SerializedName("position_ko")
    var position_ko: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("photo")
    var photo: String
)



