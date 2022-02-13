package com.twogudak.ocean_itoc_kotiln.UI.Pager.UserInfo.Edit_info

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.reviseDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.ReviseRespositroy

class Edit_userinfo_Viewmodel(application: Application) : AndroidViewModel(application){

    var reviseRespository = ReviseRespositroy()

    fun revise(token: String?, username: String?, position: String?,
                            department: String?, address: String?, belong: String?,
                            phone: String?, email: String?): MutableLiveData<reviseDTO> {
        return reviseRespository.revise(token, username,position,department,address,belong,phone,email)
    }

    fun getMessage(): LiveData<String> {
        return reviseRespository.message
    }
}