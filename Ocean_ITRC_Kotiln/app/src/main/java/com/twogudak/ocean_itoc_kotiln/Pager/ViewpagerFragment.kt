package com.twogudak.ocean_itoc_kotiln.Pager

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.twogudak.ocean_itoc_kotiln.R
import kotlinx.android.synthetic.main.fragment_viewpager.*

class ViewpagerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_viewpager, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())

        pagerAdapter.addFragment(Main())
        pagerAdapter.addFragment(research_people())
        pagerAdapter.addFragment(research_result())
        pagerAdapter.addFragment(research_continue())
        pagerAdapter.addFragment(black_board())
        pagerAdapter.addFragment(user_info())

        viewPager.adapter = pagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment","Page ${position+1}")
            }
        })


        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tabLayout.setTabTextColors(ColorStateList.valueOf(Color.WHITE))
            when(position){
                0 -> {
                    tab.text="Home"
                }

                1 -> {
                    //tab.text = "인원"
                }

                2 -> {
                    tab.text = "성과"
                }

                3 -> {
                    tab.text = "과제"
                }

                4 -> {
                    tab.text = "게시판"
                }

                5 -> {
                    tab.text = "사람"
                }
            }
        }.attach()
    }

}