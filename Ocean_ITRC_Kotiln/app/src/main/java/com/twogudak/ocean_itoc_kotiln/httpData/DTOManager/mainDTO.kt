package com.twogudak.ocean_itoc_kotiln.httpData.DTOManager

import com.google.gson.annotations.SerializedName

data class mainDTO(

    @SerializedName("permission")
    var permission: permissiondetail,


    @SerializedName("fields_data")
    var fields_data : ArrayList<fieldDetail>,

    @SerializedName("results_data")
    var results_data : ArrayList<resultDetail>

)

data class permissiondetail(
    @SerializedName("userId")
    var userId : String,
    @SerializedName("userName")
    var userName : String,
    @SerializedName("userEmail")
    var userEmail : String,
)

data class fieldDetail(
    @SerializedName("rfid")
    var rfid : Int,

    @SerializedName("classify_ko")
    var classify_ko: String,
    @SerializedName("classify_en")
    var classify_en: String,

    @SerializedName("research_name_ko")
    var research_name_ko: String,
    @SerializedName("research_name_en")
    var research_name_en: String,

    @SerializedName("business_name_ko")
    var business_name_ko: String,
    @SerializedName("business_name_en")
    var business_name_en: String,

    @SerializedName("department_name_ko")
    var department_name_ko: String,
    @SerializedName("department_name_en")
    var department_name_en: String,

    @SerializedName("subjectivity_agency_ko")
    var subjectivity_agency_ko: String,
    @SerializedName("subjectivity_agency_en")
    var subjectivity_agency_en: String,

    @SerializedName("support_agency_ko")
    var support_agency_ko: String,
    @SerializedName("support_agency_en")
    var support_agency_en: String,

    @SerializedName("participation_agency_ko")
    var participation_agency_ko: String,
    @SerializedName("participation_agency_en")
    var participation_agency_en: String,

    @SerializedName("research_goal_ko")
    var research_goal_ko: String,
    @SerializedName("research_goal_en")
    var research_goal_en: String,

    @SerializedName("research_content_ko")
    var research_content_ko: String,
    @SerializedName("research_content_en")
    var research_content_en: String,

    @SerializedName("expectation_result_ko")
    var expectation_result_ko: String,
    @SerializedName("expectation_result_en")
    var expectation_result_en: String,

    @SerializedName("research_manager_ko")
    var research_manager_ko: String,
    @SerializedName("research_manager_en")
    var research_manager_en: String,

    @SerializedName("research_belong_ko")
    var research_belong_ko: String,
    @SerializedName("research_belong_en")
    var research_belong_en: String,

    @SerializedName("date_start")
    var date_start: String,
    @SerializedName("date_end")
    var date_end: String,
)

data class resultDetail(
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
