package com.twogudak.ocean_itoc_kotiln.UI.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.userDTO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var loginviewmodel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
            loginviewmodel.tryLogin(ID_textfield.text.toString(), PassWord_textfield.toString()).observe(this){
                Log.e("test",it.userId)
            }
            loginviewmodel.getMessage().observe(this){
                Log.e("test","message")
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

    }




}