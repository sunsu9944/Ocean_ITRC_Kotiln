package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.CheckPWDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call
import retrofit2.Response

class CheckPwRespository {

    val message = MutableLiveData<String>()

    fun checkPw(userPass : String, token : String?) : MutableLiveData<CheckPWDTO> {
        val result = MutableLiveData<CheckPWDTO>()
        var Pass = hashMapOf(
            "userPW" to userPass
        )
        val call = loadRetrofit.OPEN_SERVICE

        call.checkPW(token,Pass).enqueue(object : retrofit2.Callback<CheckPWDTO>{

            override fun onResponse(call: Call<CheckPWDTO>, response: Response<CheckPWDTO>) {
                if(response.code() == 200){
                    result.value = response.body()
                    Log.e("login","${response}")
                }else{
                    message.value = "서버와의 오류가 발생했습니다."
                }
            }
            override fun onFailure(call: Call<CheckPWDTO>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })
        return result
    }
}