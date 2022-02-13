package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_continue

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Pager.People.MemberViewModel
import com.twogudak.ocean_itoc_kotiln.UI.Pager.People.PeopleAdapter
import com.twogudak.ocean_itoc_kotiln.UI.dialog.ThesisDialog
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchContinueDTO
import kotlinx.android.synthetic.main.fragment_research_continue.*

class research_continue : Fragment() {

    lateinit var mainActivity: MainActivity
    private lateinit var Research_Viewmodel : Research_Continue_Viewmodel
    lateinit var researchContinueAdapter : Research_continue_Adapter
    lateinit var peoplerecycler: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_research_continue, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        peoplerecycler = mainActivity.findViewById<RecyclerView>(R.id.research_continue_recycelerview)


        Research_Viewmodel = ViewModelProvider(this).get(Research_Continue_Viewmodel::class.java)

        val nulldata :List<ResearchContinueDTO>? = null

        researchContinueAdapter = Research_continue_Adapter(requireContext(), nulldata)
        Research_Viewmodel.getResearchcontinue().observe(viewLifecycleOwner){

            researchContinueAdapter = Research_continue_Adapter(requireContext(), it)



            peoplerecycler.adapter = researchContinueAdapter
            peoplerecycler.layoutManager = LinearLayoutManager(mainActivity)

        }

        Research_Viewmodel.getMessage().observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }


//        peoplerecycler.adapter = peopleAdapter

        mainActivity.continue_button_1.setOnClickListener {
            Log.e("test","buttonClick")
            setbackground(1)
            //전체 필터
            researchContinueAdapter.filter.filter("")

        }
        mainActivity.continue_button_2.setOnClickListener {
            setbackground(2)
            //진행중 연구 필터링
            researchContinueAdapter.filter.filter("1")

        }
        mainActivity.continue_button_3.setOnClickListener {
            setbackground(3)
            //진행 완 연구 필터링
            researchContinueAdapter.filter.filter("2")

        }

    }




    fun setbackground(number : Int){
        when(number){
            1 -> {
                continue_button_1.setBackgroundColor(Color.parseColor("#273049"))
                continue_button_2.setBackgroundColor(Color.parseColor("#354878"))
                continue_button_3.setBackgroundColor(Color.parseColor("#354878"))

            }

            2 -> {
                continue_button_2.setBackgroundColor(Color.parseColor("#273049"))
                continue_button_1.setBackgroundColor(Color.parseColor("#354878"))
                continue_button_3.setBackgroundColor(Color.parseColor("#354878"))

            }

            3 -> {
                continue_button_3.setBackgroundColor(Color.parseColor("#273049"))
                continue_button_2.setBackgroundColor(Color.parseColor("#354878"))
                continue_button_1.setBackgroundColor(Color.parseColor("#354878"))
            }


        }
    }
}