package com.twogudak.ocean_itoc_kotiln.httpData.DTOManager

import com.google.gson.annotations.SerializedName

data class NoticeDTO (
    @SerializedName("db_data")
    var db_data: ArrayList<data>
)

data class data(
    @SerializedName("qid")
    var qid: String,
    @SerializedName("userId")
    var userId: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("content")
    var content: String,
    @SerializedName("date")
    var date: String,
    @SerializedName("userName")
    var userName: String,
)