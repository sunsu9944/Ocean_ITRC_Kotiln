package com.twogudak.ocean_itoc_kotiln.Pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.twogudak.ocean_itoc_kotiln.R
import kotlinx.android.synthetic.main.notice.*

class Main : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val View =  inflater.inflate(R.layout.fragment_main, container, false)

        val notice_content_text = View.findViewById<TextView>(R.id.notice_content_text)

        notice_content_text.text = "fragment에서 택스트를 바꾸어 보았습니다."

        return View
   }



}