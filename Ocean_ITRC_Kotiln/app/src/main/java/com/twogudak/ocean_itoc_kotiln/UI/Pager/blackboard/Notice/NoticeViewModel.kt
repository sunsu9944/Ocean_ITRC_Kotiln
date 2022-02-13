package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Notice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.GalleryDTO
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.NoticeDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.GalleryRespository
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.NoticeRespository

class NoticeViewModel(application: Application) : AndroidViewModel(application) {
    var noticeRespository = NoticeRespository()

    fun getNotice(): MutableLiveData<NoticeDTO> {
        return noticeRespository.getnotice()
    }

    fun getMessage(): LiveData<String> {
        return noticeRespository.message
    }

}
