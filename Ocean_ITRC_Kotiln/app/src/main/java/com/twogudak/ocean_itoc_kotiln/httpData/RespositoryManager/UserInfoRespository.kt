package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.userDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call

class UserInfoRespository {
    val message = MutableLiveData<String>()

    fun userLogin(userId: String,userPass : String) : MutableLiveData<userDTO> {

        val result = MutableLiveData<userDTO>()
        var loginInfo = hashMapOf(
            "userId" to userId,
            "userPw" to userPass
        )

        val call = loadRetrofit.OPEN_SERVICE

        call.userLogin(loginInfo).enqueue(object : retrofit2.Callback<userDTO> {
            override fun onResponse(call: Call<userDTO>, response: retrofit2.Response<userDTO>){
                if(response.code() == 200){
                    result.value = response.body()
                }else{
                    message.value = "서버와의 오류가 발생했습니다."
                }
            }

            override fun onFailure(call: Call<userDTO>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}