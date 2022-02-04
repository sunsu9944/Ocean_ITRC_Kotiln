package com.twogudak.ocean_itoc_kotiln.UI.Pager.People

import android.content.Context
import android.os.Bundle
import android.provider.Contacts
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UserData
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO


class research_people : Fragment() {

    private lateinit var memberViewModel :MemberViewModel
    lateinit var memberAdapter: PeopleAdapter


    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity =context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val View =  inflater.inflate(R.layout.fragment_research_people, container, false)

        val nulldata :MemberDTO? = null
        var memberAdapter = PeopleAdapter(requireContext(),nulldata)


        //memberViewmodel
        memberViewModel = ViewModelProvider(this).get(MemberViewModel::class.java)
        memberViewModel.getMember(UserData(mainActivity).userinfoData.getString(UserData.TOKEN,"")).observe(viewLifecycleOwner){

            memberAdapter = PeopleAdapter(requireContext(), it)
            val peoplerecycler = mainActivity.findViewById<RecyclerView>(R.id.research_people_recycleview)
            peoplerecycler.adapter = memberAdapter
            peoplerecycler.layoutManager = GridLayoutManager(mainActivity,3)

        }

        memberViewModel.getMessage().observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }



        return View
    }
}