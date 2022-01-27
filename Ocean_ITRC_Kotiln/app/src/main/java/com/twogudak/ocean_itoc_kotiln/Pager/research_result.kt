package com.twogudak.ocean_itoc_kotiln.Pager

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.dialog.SearchPeople_Dialog
import com.twogudak.ocean_itoc_kotiln.dialog.ThesisDialog
import kotlinx.android.synthetic.main.fragment_research_result.*
import kotlinx.android.synthetic.main.researchpeople_row.view.*


class research_result : Fragment() {

    lateinit var mainActivity: MainActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_research_result, container, false)

        return view
    }


    override fun onStart() {
        super.onStart()


        val peopleAdapter = research_Recycler_adapter()
        val peoplerecycler = mainActivity.findViewById<RecyclerView>(R.id.research_result_recycelerview)


        peoplerecycler.adapter = peopleAdapter
        peoplerecycler.layoutManager = LinearLayoutManager(mainActivity)

        mainActivity.result_button_1.setOnClickListener {
            setbackground(1)
        }
        mainActivity.result_button_2.setOnClickListener {
            setbackground(2)
        }
        mainActivity.result_button_3.setOnClickListener {
            setbackground(3)
        }
        mainActivity.result_button_4.setOnClickListener {
            setbackground(4)
        }

    }


    inner class research_Recycler_adapter: RecyclerView.Adapter<research_Recycler_adapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            return 30
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = layoutInflater.inflate(R.layout.resaerch_result_row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {


        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


            override fun onClick(p0: View?) {

                Log.d("test","${adapterPosition}")

                val dia = ThesisDialog(mainActivity)
                dia.status()
                dia.textTitle?.text = "연구 성에서 클릭 ${adapterPosition}번째 자료"
                dia.start()


            }


        }

    }

    fun setbackground(number : Int){
        when(number){
            1 -> {
                result_button_1.setBackgroundColor(Color.parseColor("#273049"))
                result_button_2.setBackgroundColor(Color.parseColor("#354878"))
                result_button_3.setBackgroundColor(Color.parseColor("#354878"))
                result_button_4.setBackgroundColor(Color.parseColor("#354878"))
            }

            2 -> {
                result_button_2.setBackgroundColor(Color.parseColor("#273049"))
                result_button_1.setBackgroundColor(Color.parseColor("#354878"))
                result_button_3.setBackgroundColor(Color.parseColor("#354878"))
                result_button_4.setBackgroundColor(Color.parseColor("#354878"))
            }

            3 -> {
                result_button_3.setBackgroundColor(Color.parseColor("#273049"))
                result_button_2.setBackgroundColor(Color.parseColor("#354878"))
                result_button_1.setBackgroundColor(Color.parseColor("#354878"))
                result_button_4.setBackgroundColor(Color.parseColor("#354878"))
            }

            4 -> {
                result_button_4.setBackgroundColor(Color.parseColor("#273049"))
                result_button_2.setBackgroundColor(Color.parseColor("#354878"))
                result_button_3.setBackgroundColor(Color.parseColor("#354878"))
                result_button_1.setBackgroundColor(Color.parseColor("#354878"))
            }
        }
    }


}