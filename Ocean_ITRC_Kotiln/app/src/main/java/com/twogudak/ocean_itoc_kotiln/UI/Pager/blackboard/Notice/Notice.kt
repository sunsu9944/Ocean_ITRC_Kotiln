package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Notice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.notice_dialog
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.NoticeDTO

class notice : Fragment() {

    lateinit var mainActivity: MainActivity
    private lateinit var noticeViewModel: NoticeViewModel
    lateinit var noticeAdapter: NoticeAdapter
    lateinit var noticeRecyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_notice, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        noticeRecyclerView = mainActivity.findViewById<RecyclerView>(R.id.noticez_recyclerView)
        noticeViewModel = ViewModelProvider(this).get(NoticeViewModel::class.java)
        val nulldata : NoticeDTO? = null
        noticeAdapter = NoticeAdapter(mainActivity,nulldata)

        noticeViewModel.getNotice().observe(viewLifecycleOwner){

            noticeAdapter = NoticeAdapter(requireContext(),it)
            noticeRecyclerView.adapter = noticeAdapter
            noticeRecyclerView.layoutManager = LinearLayoutManager(mainActivity)
        }

        noticeViewModel.getMessage().observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }
}