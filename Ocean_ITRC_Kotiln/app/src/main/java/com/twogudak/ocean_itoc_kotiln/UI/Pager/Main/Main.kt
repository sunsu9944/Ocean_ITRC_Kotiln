package com.twogudak.ocean_itoc_kotiln.UI.Pager.Main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Pager.People.MemberViewModel
import com.twogudak.ocean_itoc_kotiln.UI.dialog.ThesisDialog
import com.twogudak.ocean_itoc_kotiln.UI.dialog.result_dialog
import com.twogudak.ocean_itoc_kotiln.UserData
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*


class Main : Fragment() {

    private lateinit var mainViewModel : MainViewModel


    //data setting
    var recent_resultnumber = arrayListOf<String>()
    var recent_resultname = arrayListOf<String>()
    var recent_resultdate = arrayListOf<String>()

    val recent_fieldsnumber = arrayListOf<String>()
    val recent_fieldsname = arrayListOf<String>()
    val recent_fieldsdate = arrayListOf<String>()




    //Context 받아오기
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)


        // 2. Context를 Activity로 형변환하여 할당당
        mainActivity =context as MainActivity
    }



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
        val notice_button = View.findViewById<Button>(R.id.notice_button)

        //list_id 를 받아옴
        val recent_result_list = View.findViewById<ListView>(R.id.recent_result_list)
        val recent_continue_list = View.findViewById<ListView>(R.id.recent_continue_list)
        recent_continue_list.divider = null
        recent_result_list.divider = null

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getMain(UserData(mainActivity).userinfoData.getString(UserData.TOKEN,"")).observe(viewLifecycleOwner){
            val data = it
            val results_data = it.results_data
            val field_data = it.fields_data


            for(item in results_data){
                recent_resultdate.add(item.date)
                recent_resultname.add(item.title_ko)
                recent_resultnumber.add(item.rrid)
            }

            for(item in field_data){
                recent_fieldsdate.add(item.date_start)
                recent_fieldsname.add(item.research_name_ko)
                recent_fieldsnumber.add(item.rfid.toString())
            }

            resultadapterSetting()
            fieldadapterSetting()

            //버튼 클릭 리스너 설정
            recent_result_list.setOnItemClickListener { adapterView, view, i, l ->

                val dia = result_dialog(mainActivity)
                dia.status()
                dia.title?.text = results_data[i].title_ko
                dia.date?.text = results_data[i].date
                dia.member?.text = results_data[i].writer_ko
                dia.county?.text = results_data[i].announe_nation_ko
                dia.media?.text = results_data[i].media_ko
                dia.category?.text = results_data[i].classify_ko
                dia.start()
            }

            recent_continue_list.setOnItemClickListener { adapterView, view, i, l ->

                val dia = ThesisDialog(mainActivity)
                dia.status()
                dia.textTitle?.text = field_data[i].research_name_ko
                dia.text_person?.text = field_data[i].research_manager_ko
                dia.textdate?.text = field_data[i].date_start
                dia.textbusiness_name?.text = field_data[i].business_name_ko
                dia.textdepartment?.text = field_data[i].department_name_ko
                dia.text_origanization?.text = field_data[i].subjectivity_agency_ko
                dia.text_support?.text = field_data[i].support_agency_ko
                dia.text_participating?.text = field_data[i].participation_agency_ko
                dia.text_search_goal?.text = field_data[i].research_goal_ko
                dia.text_content?.text =field_data[i].research_content_ko
                dia.text_result_examination?.text = field_data[i].expectation_result_ko

                dia.start()

            }


            //공지사항
            notice_content_text.text = it.noticedata[0].title


        }

        notice_button.setOnClickListener {
            mainActivity.viewPager.setCurrentItem(4,false)
        }

        mainViewModel.getMessage().observe(viewLifecycleOwner){
            Toast.makeText(mainActivity,it,Toast.LENGTH_SHORT)
        }

        return View
   }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //리스트 뷰를 클릭 했을 때
        recent_result_list.setOnItemClickListener { adapterView, view, i, l ->
            //mainActivity.viewPager.setCurrentItem(2,true)
            Log.d("text",recent_resultname[i])

            val dia = result_dialog(mainActivity)
            dia.status()
            dia.title?.text = "ll"
            dia.start()
        }

        //최신 과제를 클릭했을때
        recent_continue_list.setOnItemClickListener { adapterView, view, i, l ->
            Log.d("test",recent_resultname[i])

            val dia = ThesisDialog(mainActivity)
            dia.status()
            dia.changetext(dia.textTitle,"수중관측망")
           dia.start()
        }


        recent_result_button_more.setOnClickListener {
            mainActivity.viewPager.setCurrentItem(2,true)
        }

        recent_continue_button_more.setOnClickListener {
            mainActivity.viewPager.setCurrentItem(3,true)
        }


    }



    fun resultadapterSetting(){

        //recent_result_list에 셋팅할 데이터를 가지고 있을 arrayList
        val recent_result_list_datalist = ArrayList<HashMap<String,Any>>()

        // 0 ~ 4
        if(recent_resultdate.isNotEmpty()) {
            for (i in recent_resultdate.indices) {
                //항목 하나를 구성하기 위해 필요한 데이터를 담고 있는 HashMap
                val map = HashMap<String, Any>()
                map["number"] = recent_resultnumber[i]
                map["name"] = recent_resultname[i]
                map["date"] = recent_resultdate[i]

                recent_result_list_datalist.add(map)
            }
        }

        //HASH MAP에 데이터를 지정했을 때 사용했던 이름 배열
        val keys = arrayOf("number","name","date")

        //date를 셋팅할 view id
        val result_ids = intArrayOf(R.id.recent_count_row,R.id.recent_name_row,R.id.recent_date_row)

        //SimpleAdapter 생성
        val recent_result_list_adapter = SimpleAdapter(mainActivity,recent_result_list_datalist,R.layout.recent_resaerch_result_row,keys,result_ids)
        recent_result_list.adapter = recent_result_list_adapter
    }

    fun fieldadapterSetting(){

        //recent_result_list에 셋팅할 데이터를 가지고 있을 arrayList
        val recent_field_list_datalist = ArrayList<HashMap<String,Any>>()

        // 0 ~ 4
        for(i in recent_fieldsdate.indices) {
            //항목 하나를 구성하기 위해 필요한 데이터를 담고 있는 HashMap
            val map = HashMap<String,Any>()
            map["number"] = recent_fieldsnumber[i]
            map["name"] = recent_fieldsname[i]
            map["date"] = recent_fieldsdate[i]

            recent_field_list_datalist.add(map)
        }

        //HASH MAP에 데이터를 지정했을 때 사용했던 이름 배열
        val keys = arrayOf("number","name","date")


        //date를 셋팅할 view id
        val continue_ids = intArrayOf(R.id.recent_continue_count_row,R.id.recent_continue_name_row,R.id.recent_continue_date_row)


        //SimpleAdapter 생성
        val recent_continue_list_adapter = SimpleAdapter(mainActivity,recent_field_list_datalist,R.layout.recent_research_continue_row,keys,continue_ids)
        recent_continue_list.adapter = recent_continue_list_adapter

    }
}


