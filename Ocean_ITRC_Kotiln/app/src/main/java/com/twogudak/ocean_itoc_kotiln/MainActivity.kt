package com.twogudak.ocean_itoc_kotiln

import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.twogudak.ocean_itoc_kotiln.Pager.ViewpagerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kotlinx.android.synthetic.main.notice.*
import kotlinx.android.synthetic.main.research_people.*
import kotlinx.android.synthetic.main.titlebar.*

class MainActivity : AppCompatActivity() {

    val frag = ViewpagerFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val topBar = layoutInflater.inflate(R.layout.titlebar,null)
        supportActionBar?.customView = topBar
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#121827")))



        //viewPager 불러오기
        transFragment("viewPager")

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.titlemenu,menu)

        val search = menu?.findItem(R.id.title_search)

        val searchbar = search?.actionView as SearchView

        searchbar.queryHint = "Search"

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.Korean ->{
                Log.d("test","Korea")
            }
            R.id.English -> {
                Log.d("test","english")
            }
        }

        return super.onOptionsItemSelected(item)
    }












}