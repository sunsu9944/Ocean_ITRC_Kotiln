package com.twogudak.ocean_itoc_kotiln.UI.Pager.Main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.mainDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.MainRespository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var mainRepository = MainRespository()

    fun getMain(token: String?): MutableLiveData<mainDTO> {
        return mainRepository.getMain(token)
    }

    fun getMessage(): LiveData<String> {
        return mainRepository.message
    }

}