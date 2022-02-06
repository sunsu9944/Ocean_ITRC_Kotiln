package com.twogudak.ocean_itoc_kotiln.httpData.DTOManager

import com.google.gson.annotations.SerializedName

data class GalleryDTO(
    @SerializedName("db_data")
    val db_data : ArrayList<db_data>,

)


data class db_data(
    @SerializedName("gid")
    val gid : String,
    @SerializedName("title_ko")
    val title_ko: String,
    @SerializedName("title_en")
    val title_en: String,
    @SerializedName("gDate")
    val gDate: String,
    @SerializedName("img_src")
    val img_src: String
)