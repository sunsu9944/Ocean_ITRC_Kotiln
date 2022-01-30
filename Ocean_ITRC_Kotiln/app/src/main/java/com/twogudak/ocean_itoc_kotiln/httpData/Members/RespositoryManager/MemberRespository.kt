package com.twogudak.ocean_itoc_kotiln.httpData.Members.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO
import com.twogudak.ocean_itoc_kotiln.httpData.Members.loadRetrofit
import retrofit2.Call

class MemberRespository {

    val message = MutableLiveData<String>()

    fun getMember(): MutableLiveData<MemberDTO> {

        val result = MutableLiveData<MemberDTO>()
        val call = loadRetrofit.OPEN_SERVICE

        call.getMembers().enqueue(object : retrofit2.Callback<MemberDTO> {
            override fun onResponse(call: Call<MemberDTO>, response: retrofit2.Response<MemberDTO>){
                result.value = response.body()
            }

            override fun onFailure(call: Call<MemberDTO>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}