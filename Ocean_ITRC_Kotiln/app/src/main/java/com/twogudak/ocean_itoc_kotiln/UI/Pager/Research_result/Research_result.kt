package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.ThesisDialog
import com.twogudak.ocean_itoc_kotiln.UI.dialog.result_dialog
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchResultsDTO
import kotlinx.android.synthetic.main.fragment_research_result.*


class research_result : Fragment() {

    lateinit var mainActivity: MainActivity
    private lateinit var Research_result_Viewmodel : Research_result_Viewmodel
    lateinit var researchResultAdapter : Research_result_Adapter
    lateinit var peoplerecycler : RecyclerView


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


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Research_result_Viewmodel = ViewModelProvider(this).get(com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result.Research_result_Viewmodel::class.java)

        peoplerecycler = mainActivity.findViewById<RecyclerView>(R.id.research_result_recycelerview)
        val init: List<ResearchResultsDTO>? = null

        researchResultAdapter = Research_result_Adapter(requireContext(),init)

        Research_result_Viewmodel.getResearchcontinue("특허").observe(viewLifecycleOwner){
            researchResultAdapter = Research_result_Adapter(requireContext(),it)
            peoplerecycler.adapter = researchResultAdapter
            peoplerecycler.layoutManager = LinearLayoutManager(context)
        }

        Research_result_Viewmodel.getMessage().observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }


        mainActivity.result_button_1.setOnClickListener {
            setbackground(1)
            Log.e("test","1")
            Research_result_Viewmodel.getResearchcontinue("특허").observe(viewLifecycleOwner){
                researchResultAdapter = Research_result_Adapter(requireContext(),it)
                peoplerecycler.adapter = researchResultAdapter
                peoplerecycler.layoutManager = LinearLayoutManager(context)
            }
        }
        mainActivity.result_button_2.setOnClickListener {
            setbackground(2)
            Log.e("test","2")
            Research_result_Viewmodel.getResearchcontinue("논문").observe(viewLifecycleOwner){
                researchResultAdapter = Research_result_Adapter(requireContext(),it)
                peoplerecycler.adapter = researchResultAdapter
                peoplerecycler.layoutManager = LinearLayoutManager(context)
            }
        }
        mainActivity.result_button_3.setOnClickListener {
            setbackground(3)
            Log.e("test","3")
            Research_result_Viewmodel.getResearchcontinue("발표").observe(viewLifecycleOwner){
                researchResultAdapter = Research_result_Adapter(requireContext(),it)
                peoplerecycler.adapter = researchResultAdapter
                peoplerecycler.layoutManager = LinearLayoutManager(context)
            }
        }

    }


    fun setbackground(number : Int){
        when(number){
            1 -> {
                result_button_1.setBackgroundColor(Color.parseColor("#273049"))
                result_button_2.setBackgroundColor(Color.parseColor("#354878"))
                result_button_3.setBackgroundColor(Color.parseColor("#354878"))
            }

            2 -> {
                result_button_2.setBackgroundColor(Color.parseColor("#273049"))
                result_button_1.setBackgroundColor(Color.parseColor("#354878"))
                result_button_3.setBackgroundColor(Color.parseColor("#354878"))
            }

            3 -> {
                result_button_3.setBackgroundColor(Color.parseColor("#273049"))
                result_button_2.setBackgroundColor(Color.parseColor("#354878"))
                result_button_1.setBackgroundColor(Color.parseColor("#354878"))
            }

        }
    }


}