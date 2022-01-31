package com.twogudak.ocean_itoc_kotiln.UI.Login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.userDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.UserInfoRespository

class LoginViewModel(application: Application): AndroidViewModel(application) {
    var loginRepository = UserInfoRespository()

    fun tryLogin(userId: String, userPass: String): LiveData<userDTO> {
        return loginRepository.userLogin(userId, userPass)
    }
    fun getMessage(): LiveData<String> {
        return loginRepository.message
    }
}