package com.twogudak.ocean_itoc_kotiln.httpData.DTOManager

import com.google.gson.annotations.SerializedName

data class ResearchResultsDTO (
    @SerializedName("rrid") //번호
    var rrid : String,
    @SerializedName("group")//그룹
    var group: String,
    @SerializedName("classify_ko") //발표
    var classify_ko : String,
    @SerializedName("title_ko") //학술 이름
    var title_ko : String,
    @SerializedName("academic_ko") //학술발표지
    var academic_ko : String,
    @SerializedName("writer_ko") //작성자
    var writer_ko : String,
    @SerializedName("media_ko")
    var media_ko : String,
    @SerializedName("announe_nation_ko") //발표 나라
    var announe_nation_ko : String,
    @SerializedName("relation_subject_ko")
    var relation_subject_ko : String,
    @SerializedName("abstract_ko")
    var abstract_ko : String,
    @SerializedName("date")
    var date : String,
    @SerializedName("application_num")
    var application_num : String
)