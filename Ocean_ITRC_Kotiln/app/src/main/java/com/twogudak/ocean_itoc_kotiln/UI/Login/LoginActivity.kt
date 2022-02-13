package com.twogudak.ocean_itoc_kotiln.UI.Login

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UserData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.userDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.UserInfoRespository
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    lateinit var loginviewmodel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val ActivityManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?

        login_layout.setOnClickListener {
            ActivityManager?.hideSoftInputFromWindow(it.windowToken,0)
        }


        PassWord_textfield.setOnKeyListener { view, i, keyEvent ->
            if(i == KeyEvent.KEYCODE_ENTER){


                ActivityManager?.hideSoftInputFromWindow(view.windowToken,0)
                loginAction()

                true
            }
            false
        }
        
        

        login_button.setOnClickListener {
            loginAction()
        }

    }

    fun loginAction(){
        loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginviewmodel.tryLogin(ID_textfield.text.toString(),PassWord_textfield.text.toString()).observe(this){
            Log.e("login","${it}")
            login_button.setOnClickListener {  }
            if(UserData(this).setuserinfo(it)){
                if(it.message == "정상적으로 로그인 되었습니다."){
                    finish()
                }else {
                    login_button.setOnClickListener {
                        loginAction()
                    }
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }

        }

        loginviewmodel.getMessage().observe(this){
            Log.e("test","message")
            login_button.setOnClickListener {
                loginAction()
            }
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }




}