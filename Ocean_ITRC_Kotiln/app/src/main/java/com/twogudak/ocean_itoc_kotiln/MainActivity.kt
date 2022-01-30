package com.twogudak.ocean_itoc_kotiln

import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.text.set
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.twogudak.ocean_itoc_kotiln.UI.Pager.ViewpagerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kotlinx.android.synthetic.main.notice.*
import kotlinx.android.synthetic.main.research_people.*
import kotlinx.android.synthetic.main.titlebar.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val frag = ViewpagerFragment()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setSupportActionBar(topbar)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val topBar = layoutInflater.inflate(R.layout.titlebar,null)
        supportActionBar?.customView = topBar
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#121827")))

        //viewPager 불러오기
        transFragment("viewPager")

        getdata()


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



        //액션뷰가 펼쳐졌을때나 접혀졌을때 구
        val ActionViewOpen = object : MenuItem.OnActionExpandListener{

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                Log.d("test","접혀")
                return true
            }

            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                Log.d("test","펼쳐")
                return true
            }
        }

        val searching = object : SearchView.OnQueryTextListener{

            //텍스트가 바뀌면
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            //누르면
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("test","검색 구현")
                searchbar.clearFocus()

                return true
            }
        }

        search.setOnActionExpandListener(ActionViewOpen)
        searchbar.setOnQueryTextListener(searching)

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




    fun getdata(){
        thread {
            val url = URL("http://oceanic-ict.hoseo.ac.kr/members/android/memberALL")

            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"

            //문자열 데이터를 읽어온다.
            val isr = InputStreamReader(conn.inputStream,"UTF-8")
            val br = BufferedReader(isr)

            var str:String? = null
            val buf = StringBuffer()
            do {
                str = br.readLine()
                if(str != null) {
                    buf.append(str)
                }
            }while(str!=null)

            val data = buf.toString()

            //jsonData 분석하기
            val root = JSONObject(data)
            val array = root.optJSONArray("result")
            for(i in 0 until array.length()){
                val obj = array.getJSONObject(i)
                val peoplename = obj.getString("name_ko")
                val position_ko_row = obj.getString("position_ko")
                val department_ko_row = obj.getString("department_ko")
                val phonenumber = obj.getString("phone")
                val email = obj.getString("email")



                peope_name.add(peoplename)
                position_ko.add(position_ko_row)
                department_ko.add(department_ko_row)
                phone.add(phonenumber)
                emailadress.add(email)
            }

        }
   }

    val peope_name = arrayListOf<String>()
    val position_ko = arrayListOf<String>()
    val department_ko = arrayListOf<String>()
    val phone = arrayListOf<String>()
    val emailadress = arrayListOf<String>()

    val imgtitle = arrayOf(
        "짧은글자","긴글자가가가가가가가각","긴글자한번더긴가가가가가","짧은글","홀수를맞추",
        "짧은글자","긴글자가가가가가가가각","긴글자한번더긴가가가가가","짧은글","홀수를맞추",
        "짧은글자","긴글자가가가가가가가각","긴글자한번더긴가가가가가","짧은글","홀수를맞추",
        "짧은글자","긴글자가가가가가가가각","긴글자한번더긴가가가가가","짧은글","홀수를맞추",
    )



}