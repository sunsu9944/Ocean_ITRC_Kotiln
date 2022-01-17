package com.twogudak.ocean_itoc_kotiln

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.twogudak.ocean_itoc_kotiln.Pager.ViewpagerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kotlinx.android.synthetic.main.research_people.*
import kotlinx.android.synthetic.main.titlebar.*

class MainActivity : AppCompatActivity() {

    val frag = ViewpagerFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //viewPager 불러오기
        transFragment("viewPager")

        //한영 바꾸기
        titlebar_changelang.setOnClickListener {

            val popupchanglang = PopupMenu(this,titlebar_changelang)

            //메뉴를 구성한다.
            popupchanglang.menu?.add(Menu.NONE,Menu.FIRST,Menu.NONE,"한국어")
            popupchanglang.menu?.add(Menu.NONE,Menu.FIRST + 1, Menu.NONE, "English")

            popupchanglang.setOnMenuItemClickListener {

                when(it.itemId){
                    Menu.FIRST -> {
                        Log.d("test","한글로 바꾸기 구현")
                    }
                    Menu.FIRST + 1 -> {
                        Log.d("test","영어로 바꾸기 구현")
                   }
                }
                true
            }
            popupchanglang.show()
        }


    }

    fun transFragment(name: String){
        val tran = supportFragmentManager.beginTransaction()

        when(name){

            "viewPager" -> {
                tran.replace(R.id.main_View_Pager, frag)
            }
        }
        tran.commit()


    }











}