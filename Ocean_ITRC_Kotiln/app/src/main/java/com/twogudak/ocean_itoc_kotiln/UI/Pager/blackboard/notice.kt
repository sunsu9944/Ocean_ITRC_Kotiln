package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.notice_dialog

class notice : Fragment() {

    lateinit var mainActivity: MainActivity


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

        val noticeAdapter = notice_Recycler_adapter()
        val noticerecycler = mainActivity.findViewById<RecyclerView>(R.id.noticez_recyclerView)


        noticerecycler.adapter = noticeAdapter
        noticerecycler.layoutManager = LinearLayoutManager(mainActivity)

    }


    inner class notice_Recycler_adapter: RecyclerView.Adapter<notice_Recycler_adapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            return 3
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = layoutInflater.inflate(R.layout.notice_row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {


        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            override fun onClick(p0: View?) {
                Log.d("test","${adapterPosition}")

                val dialog = notice_dialog(mainActivity)
                dialog.status()
                dialog.start()
            }
        }
    }

}