package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.mainDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call

class MainRespository {
    val message = MutableLiveData<String>()

    fun getMain(token: String?): MutableLiveData<mainDTO> {

        val result = MutableLiveData<mainDTO>()

        val call = loadRetrofit.OPEN_SERVICE

        call.main(token).enqueue(object : retrofit2.Callback<mainDTO> {
            override fun onResponse(call: Call<mainDTO>, response: retrofit2.Response<mainDTO>){
                result.value = response.body()
                Log.e("login",result.value.toString())
            }

            override fun onFailure(call: Call<mainDTO>, t: Throwable){
                Log.e("qwer",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}