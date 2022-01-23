package com.twogudak.ocean_itoc_kotiln.Pager.blackboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.twogudak.ocean_itoc_kotiln.R

class gallery : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view  = layoutInflater.inflate(R.layout.fragment_gallery,container,false)

        return view
    }
}