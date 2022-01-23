package com.twogudak.ocean_itoc_kotiln.Pager

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout.INDICATOR_GRAVITY_TOP
import com.google.android.material.tabs.TabLayout.SCROLL_INDICATOR_TOP
import com.google.android.material.tabs.TabLayoutMediator
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.Pager.blackboard.freetalk
import com.twogudak.ocean_itoc_kotiln.Pager.blackboard.gallery
import com.twogudak.ocean_itoc_kotiln.Pager.blackboard.notice
import com.twogudak.ocean_itoc_kotiln.R
import kotlinx.android.synthetic.main.fragment_black_board.*
import kotlinx.android.synthetic.main.fragment_viewpager.*

class black_board : Fragment() {

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
        return inflater.inflate(R.layout.fragment_black_board, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())

        pagerAdapter.addFragment(notice())
        pagerAdapter.addFragment(gallery())
        pagerAdapter.addFragment(freetalk())

        val blackboard_viewpager = mainActivity.findViewById<ViewPager2>(R.id.blackboard_viewpager)

        blackboard_viewpager.adapter = pagerAdapter

        blackboard_viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment","Page ${position+1}")
            }
        })


        TabLayoutMediator(blackboard_tablayout, blackboard_viewpager) {tab, position ->
            blackboard_tablayout.setTabTextColors(ColorStateList.valueOf(Color.WHITE))
            blackboard_tablayout.setBackgroundColor(Color.parseColor("#354878"))

            when(position){
                0 -> {
                    tab.text="공지사항"
                }

                1 -> {
                    tab.text = "갤러리"
                }

                2 -> {
                    tab.text = "자유게시판"
                }
            }
        }.attach()


    }
}