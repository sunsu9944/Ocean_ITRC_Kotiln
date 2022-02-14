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
               phone: String?, email: String?,input_Pw: String?, check_Pw: String?): MutableLiveData<reviseDTO> {

        val result = MutableLiveData<reviseDTO>()
        val call = loadRetrofit.OPEN_SERVICE
        val reviseinfo = hashMapOf(
            "inputName" to username,
            "userEmail" to email,
            "Belong" to belong,
            "Department" to department,
            "Position" to position,
            "inputAdd" to address,
            "inputPhone" to phone,
            "inputPw" to input_Pw,
            "checkPw" to check_Pw
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