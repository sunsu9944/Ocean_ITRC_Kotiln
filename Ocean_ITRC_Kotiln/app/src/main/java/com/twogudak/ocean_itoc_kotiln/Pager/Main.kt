package com.twogudak.ocean_itoc_kotiln.Pager

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import kotlinx.android.synthetic.main.notice.*
import org.w3c.dom.Text

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

        notice_content_text.text = "fragment에서 택스트를 바꾸어 보았습니다."

        //list_id 를 받아옴
        val recent_result_list = View.findViewById<ListView>(R.id.recent_result_list)


        //list row id를 받아옴
        val recent_result_row_count = mainActivity.findViewById<TextView>(R.id.recent_count_row)
        val recent_result_row_name = mainActivity.findViewById<TextView>(R.id.recent_name_row)
        val recent_result_row_date = mainActivity.findViewById<TextView>(R.id.recent_date_row)

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
        val ids = intArrayOf(R.id.recent_count_row,R.id.recent_name_row,R.id.recent_date_row)


        //SimpleAdapter 생성
        val recent_result_list_adapter = SimpleAdapter(mainActivity,recent_result_list_datalist,R.layout.recent_resaerch_result_row,keys,ids)
        recent_result_list.adapter = recent_result_list_adapter

        val saperalte = mainActivity.findViewById<View>(R.id.recent_result_saperlate)




        return View
   }



}


