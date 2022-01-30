package com.twogudak.ocean_itoc_kotiln.UI.Pager.People

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.MemberRespository
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO

class MemberViewModel(application: Application) : AndroidViewModel(application){
    var memberRepository = MemberRespository()

    fun getMember(): MutableLiveData<MemberDTO> {
        return memberRepository.getMember()
    }

    fun getMessage(): LiveData<String> {
        return memberRepository.message
    }
}