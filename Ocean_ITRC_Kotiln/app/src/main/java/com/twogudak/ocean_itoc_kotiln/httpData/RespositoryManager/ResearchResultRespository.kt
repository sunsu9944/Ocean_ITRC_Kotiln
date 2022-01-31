package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchResultsDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call

class ResearchResultRespository {
    val message = MutableLiveData<String>()

    fun getResearchResults(classifiy: String) : MutableLiveData<List<ResearchResultsDTO>> {
        val result = MutableLiveData<List<ResearchResultsDTO>>()
        val call = loadRetrofit.OPEN_SERVICE

        call.getResearchResults(classifiy).enqueue(object : retrofit2.Callback<List<ResearchResultsDTO>> {
            override fun onResponse(call: Call<List<ResearchResultsDTO>>, response: retrofit2.Response<List<ResearchResultsDTO>>){
                result.value = response.body()
            }

            override fun onFailure(call: Call<List<ResearchResultsDTO>>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}