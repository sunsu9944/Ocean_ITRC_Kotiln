package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchContinueDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call

class ResearchContinueRespository {
    val message = MutableLiveData<String>()

    fun getResearchContinue() : MutableLiveData<List<ResearchContinueDTO>>{
        val result = MutableLiveData<List<ResearchContinueDTO>>()
        val call = loadRetrofit.OPEN_SERVICE

        call.getResearchContinue().enqueue(object : retrofit2.Callback<List<ResearchContinueDTO>> {
            override fun onResponse(call: Call<List<ResearchContinueDTO>>, response: retrofit2.Response<List<ResearchContinueDTO>>){
                result.value = response.body()
            }

            override fun onFailure(call: Call<List<ResearchContinueDTO>>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}

