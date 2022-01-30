package com.twogudak.ocean_itoc_kotiln.UI.Pager.People

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Pager.dialog.SearchPeople_Dialog
import kotlinx.android.synthetic.main.researchpeople_row.view.*


class research_people : Fragment() {

    private lateinit var memberViewModel :MemberViewModel



    lateinit var mainActivity: MainActivity

    lateinit var peoplename: ArrayList<String>
    lateinit var peopleposition: ArrayList<String>
    lateinit var peopledepartemnt: ArrayList<String>
    lateinit var phonenumber: ArrayList<String>
    lateinit var emailadress: ArrayList<String>


    override fun onAttach(context: Context) {
        super.onAttach(context)


        // 2. Context를 Activity로 형변환하여 할당당
        mainActivity =context as MainActivity
        peoplename = mainActivity.peope_name
        peopleposition = mainActivity.position_ko
        peopledepartemnt = mainActivity.department_ko
        phonenumber = mainActivity.phone
        emailadress = mainActivity.emailadress






    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val View =  inflater.inflate(R.layout.fragment_research_people, container, false)


        memberViewModel = ViewModelProvider(this).get(MemberViewModel::class.java)
        memberViewModel.getMember().observe(viewLifecycleOwner){

            val memberAdapter = PeopleAdapter(requireContext(), it)
            val peoplerecycler = mainActivity.findViewById<RecyclerView>(R.id.research_people_recycleview)
            peoplerecycler.adapter = memberAdapter
            peoplerecycler.layoutManager = GridLayoutManager(mainActivity,3)

        }

        memberViewModel.getMessage().observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }



        return View
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //val peopleAdapter = PeopleAdapter(mainActivity)




//        peoplerecycler.adapter = peopleAdapter
//        peoplerecycler.layoutManager = GridLayoutManager(mainActivity,3)

    }

    inner class research_Recycler_adapter: RecyclerView.Adapter<research_Recycler_adapter.ViewHolderClass>() {



        override fun getItemCount(): Int {
            return peoplename.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = layoutInflater.inflate(R.layout.researchpeople_row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            val rowName = itemView.findViewById<TextView>(R.id.research_people_textView)

           return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

            holder.rowName.text = "${peoplename[position]}"
            holder.rowposition.text = "${peopleposition[position]}"
        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


            val rowImageView = itemView.research_people_img
            val rowName = itemView.research_people_textView
            val rowposition = itemView.people_role

            override fun onClick(p0: View?) {

                Log.d("test","${adapterPosition}")
                val dia = SearchPeople_Dialog(mainActivity)

                dia.status()
                dia.changetext(dia.peoplename,"${peoplename[adapterPosition]}")
                dia.changetext(dia.people_rol,"${peopleposition[adapterPosition]}")
                dia.changetext(dia.people_department,"${peopledepartemnt[adapterPosition]}")
                dia.changetext(dia.people_phonenumber,"${phonenumber[adapterPosition]}")
                dia.changetext(dia.people_email,"${emailadress[adapterPosition]}")

                dia.start()

            }
        }
    }

}