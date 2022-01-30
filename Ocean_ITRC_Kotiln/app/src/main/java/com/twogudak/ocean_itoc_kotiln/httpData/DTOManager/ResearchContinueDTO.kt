package com.twogudak.ocean_itoc_kotiln.httpData.DTOManager

import com.google.gson.annotations.SerializedName

data class ResearchContinueDTO(
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
