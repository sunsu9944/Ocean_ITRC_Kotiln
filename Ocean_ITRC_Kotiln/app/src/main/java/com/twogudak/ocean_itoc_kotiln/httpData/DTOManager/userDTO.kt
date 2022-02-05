package com.twogudak.ocean_itoc_kotiln.httpData.DTOManager

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class userDTO(
    @SerializedName("userId")
    var userId: String,
    @SerializedName("userName")
    var userName: String,
    @SerializedName("userEmail")
    var userEmail: String,
    @SerializedName("userNameEN")
    var userNameEN: String,
    @SerializedName("userBelong")
    var userBelong: String,
    @SerializedName("userDepartment")
    var userDepartment: String,
    @SerializedName("userPosition")
    var userPosition: String,
    @SerializedName("userAdd")
    var userAdd: String,
    @SerializedName("userPhone")
    var userPhone: String,
    @SerializedName("userImg")
    var userImg: String,
    @SerializedName("Token")
    var Token: String,
    @SerializedName("message")
    var message: String
): Serializable


