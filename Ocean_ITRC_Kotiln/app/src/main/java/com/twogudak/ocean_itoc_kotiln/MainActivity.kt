package com.twogudak.ocean_itoc_kotiln

import android.content.Context
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
import com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result.user_info
import com.twogudak.ocean_itoc_kotiln.UI.Pager.ViewpagerFragment
import com.twogudak.ocean_itoc_kotiln.httpData.DOMAIN
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kotlinx.android.synthetic.main.notice.*
import kotlinx.android.synthetic.main.research_people.*
import kotlinx.android.synthetic.main.titlebar.*
import okhttp3.Cookie
import okhttp3.HttpUrl
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.http.Url
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.CookieManager
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.math.log
import java.net.CookieStore

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

        UserData(this).getUserInfo()

        if(checkLogin(this)){
            val token = UserData(this).userinfoData.getString(UserData.TOKEN,"default")
            Log.e("login","Logined")
            Log.e("login",token.toString())
        } else {
            Log.e("login","notLogin")
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

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.titlemenu,menu)
//
//        val search = menu?.findItem(R.id.title_search)
//        val searchbar = search?.actionView as SearchView
//
//
//
//        //액션뷰가 펼쳐졌을때나 접혀졌을때 구
//        val ActionViewOpen = object : MenuItem.OnActionExpandListener{
//
//            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
//                return true
//            }
//
//            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
//                return true
//            }
//        }
//
//        val searching = object : SearchView.OnQueryTextListener{
//
//            //텍스트가 바뀌면
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//
//            //누르면
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                Log.d("test","검색 구현")
//                searchbar.clearFocus()
//
//                return true
//            }
//        }
//
//        search.setOnActionExpandListener(ActionViewOpen)
//        searchbar.setOnQueryTextListener(searching)
//
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when(item.itemId){
//            R.id.Korean ->{
//                Log.d("test","Korea")
//            }
//            R.id.English -> {
//                Log.d("test","english")
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }




    fun checkLogin(context: Context):Boolean{
        if(UserData(this).userinfoData.getString(UserData.USER_ID,"").equals("")){
            return false
        } else {
            return true
        }
    }



}