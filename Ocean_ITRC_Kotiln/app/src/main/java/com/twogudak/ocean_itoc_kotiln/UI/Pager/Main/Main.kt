package com.twogudak.ocean_itoc_kotiln.UI.Pager.Main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.ThesisDialog
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*

class Main : Fragment() {


    //data setting
    val recent_resultnumber = arrayOf("111","30","1","3","56")
    val recent_resultname = arrayOf("고준혁이 고준혁 했습니다. 아싸라비아야 콜롬비아","고준혁이 고준혁 했습니다. 아싸라비아야 콜롬비아 조금 더 길게 해봅시다",
                                    "고준혁이 고준혁 했습니다. 아싸라비아야 콜롬비아","고준혁이 고준혁 했습니다. 아싸라비아야 콜롬비아",
                                    "고준혁이 고준혁 했습니다. 아싸라비아야 콜롬비아")

    val recent_resultdate = arrayOf("2020.08.01","2020.08.02","2020.08.03","2020.08.04","2020.08.05",)


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

        notice_content_text.text = "Android-kotlin 첫번째 버전입니다."

        notice_button.setOnClickListener {
            mainActivity.viewPager.setCurrentItem(4,false)
        }


        //list_id 를 받아옴
        val recent_result_list = View.findViewById<ListView>(R.id.recent_result_list)
        val recent_continue_list = View.findViewById<ListView>(R.id.recent_continue_list)
        recent_continue_list.divider = null
        recent_result_list.divider = null



        //recent_result_list에 셋팅할 데이터를 가지고 있을 arrayList

        val recent_result_list_datalist = ArrayList<HashMap<String,Any>>()

        // 0 ~ 4
        for(i in recent_resultdate.indices) {
            //항목 하나를 구성하기 위해 필요한 데이터를 담고 있는 HashMap
            val map = HashMap<String,Any>()
            map["number"] = recent_resultnumber[i]
            map["name"] = recent_resultname[i]
            map["date"] = recent_resultdate[i]

            recent_result_list_datalist.add(map)
        }

        //HASH MAP에 데이터를 지정했을 때 사용했던 이름 배열
        val keys = arrayOf("number","name","date")


        //date를 셋팅할 view id
        val result_ids = intArrayOf(R.id.recent_count_row,R.id.recent_name_row,R.id.recent_date_row)
        val continue_ids = intArrayOf(R.id.recent_continue_count_row,R.id.recent_continue_name_row,R.id.recent_continue_date_row)


        //SimpleAdapter 생성
        val recent_result_list_adapter = SimpleAdapter(mainActivity,recent_result_list_datalist,R.layout.recent_resaerch_result_row,keys,result_ids)
        recent_result_list.adapter = recent_result_list_adapter

        val recent_continue_list_adapter = SimpleAdapter(mainActivity,recent_result_list_datalist,R.layout.recent_research_continue_row,keys,continue_ids)
        recent_continue_list.adapter = recent_continue_list_adapter


        return View
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //리스트 뷰를 클릭 했을 때
        recent_result_list.setOnItemClickListener { adapterView, view, i, l ->
            //mainActivity.viewPager.setCurrentItem(2,true)
            Log.d("text",recent_resultname[i])

            val dia = ThesisDialog(mainActivity)
            dia.status()
            dia.textTitle?.text = "분산형 수중관측 제어망 개발"
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




}


