package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Gallery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.GalleryDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.GalleryRespository

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    var galleryRepository = GalleryRespository()

    fun getMain(token: String?): MutableLiveData<GalleryDTO> {
        return galleryRepository.getgallery(token)
    }

    fun getMessage(): LiveData<String> {
        return galleryRepository.message
    }

}