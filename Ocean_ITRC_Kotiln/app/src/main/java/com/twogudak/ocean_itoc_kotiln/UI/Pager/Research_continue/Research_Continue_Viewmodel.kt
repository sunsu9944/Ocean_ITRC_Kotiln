package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_continue

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchContinueDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.ResearchContinueRespository

class Research_Continue_Viewmodel(application: Application) : AndroidViewModel(application){
    var resarchRepository = ResearchContinueRespository()

    fun getResearchcontinue(): MutableLiveData<List<ResearchContinueDTO>> {
        return resarchRepository.getResearchContinue()
    }

    fun getMessage(): LiveData<String> {
        return resarchRepository.message
    }
}