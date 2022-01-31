package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchResultsDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.ResearchResultRespository

class Research_result_Viewmodel(application: Application) : AndroidViewModel(application){

    var resarchResultRepository = ResearchResultRespository()

    fun getResearchcontinue(classifiy: String): MutableLiveData<List<ResearchResultsDTO>> {
        return resarchResultRepository.getResearchResults(classifiy)
    }

    fun getMessage(): LiveData<String> {
        return resarchResultRepository.message
    }
}