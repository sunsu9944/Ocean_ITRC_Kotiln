package com.twogudak.ocean_itoc_kotiln.Pager

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import kotlinx.android.synthetic.main.researchpeople_row.view.*


class research_people : Fragment() {


    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)


        // 2. Context를 Activity로 형변환하여 할당당
        mainActivity =context as MainActivity
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val View =  inflater.inflate(R.layout.fragment_research_people, container, false)



        return View
    }

    override fun onStart() {
        super.onStart()

        val peopleAdapter = research_Recycler_adapter()

        val peoplerecycler = mainActivity.findViewById<RecyclerView>(R.id.research_people_recycleview)
        peoplerecycler.adapter = peopleAdapter
        peoplerecycler.layoutManager = GridLayoutManager(mainActivity,3)



    }

    inner class research_Recycler_adapter: RecyclerView.Adapter<research_Recycler_adapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            return 30
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = layoutInflater.inflate(R.layout.researchpeople_row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


            val rowImageView = itemView.research_people_img
            val rowName = itemView.research_people_textView

            override fun onClick(p0: View?) {

                rowName.text = "클릭함"
            }


        }



    }

}