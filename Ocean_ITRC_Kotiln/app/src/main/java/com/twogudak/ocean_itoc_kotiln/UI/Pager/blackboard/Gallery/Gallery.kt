package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UserData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.GalleryDTO
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.db_data
import kotlinx.android.synthetic.main.gallery_row.view.*

class gallery : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var imgtitle: Array<String>
    private lateinit var galleryViewModel : GalleryViewModel
    lateinit var galleryAdapter : GalleryAdapter
    lateinit var galleryRecycler : RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
       // imgtitle = mainActivity.imgtitle

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = layoutInflater.inflate(R.layout.fragment_gallery,container,false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        galleryRecycler = mainActivity.findViewById<RecyclerView>(R.id.gallery_recyclerView)
        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        val nulldata : GalleryDTO? = null
        galleryAdapter = GalleryAdapter(requireContext(),nulldata)

        val token =  UserData(mainActivity).userinfoData.getString(UserData.TOKEN,"")
        galleryViewModel.getMain(token).observe(viewLifecycleOwner){

            galleryAdapter = GalleryAdapter(requireContext(),it)
            galleryRecycler.adapter = galleryAdapter
            galleryRecycler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        }
    }
}