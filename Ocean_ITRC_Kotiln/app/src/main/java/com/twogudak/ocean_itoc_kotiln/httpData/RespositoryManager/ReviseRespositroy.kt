package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.reviseDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call

class ReviseRespositroy {

    val message = MutableLiveData<String>()

    fun revise(token: String?, username: String?, position: String?,
               department: String?, address: String?, belong: String?,
               phone: String?, email: String?): MutableLiveData<reviseDTO> {

        val result = MutableLiveData<reviseDTO>()
        val call = loadRetrofit.OPEN_SERVICE
        val reviseinfo = hashMapOf(
            "userName" to username,
            "userEmail" to email,
            "userBelong" to belong,
            "userDepartment" to department,
            "userPosition" to position,
            "userAdd" to address,
            "userPhone" to phone
        )

        call.revise(token,reviseinfo).enqueue(object : retrofit2.Callback<reviseDTO> {
            override fun onResponse(call: Call<reviseDTO>, response: retrofit2.Response<reviseDTO>){
                result.value = response.body()
                Log.e("test",result.value.toString())
            }

            override fun onFailure(call: Call<reviseDTO>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}