package com.twogudak.ocean_itoc_kotiln.UI.Pager.UserInfo.Edit_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Login.LoginViewModel
import com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result.Research_result_Viewmodel
import com.twogudak.ocean_itoc_kotiln.UserData
import kotlinx.android.synthetic.main.activity_edit_userinfo.*

class Edit_userinfo : AppCompatActivity() {

    private lateinit var Edit_userinfo_Viewmodel: Edit_userinfo_Viewmodel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_userinfo)

        Edit_userinfo_Viewmodel = ViewModelProvider(this).get(com.twogudak.ocean_itoc_kotiln.UI.Pager.UserInfo.Edit_info.Edit_userinfo_Viewmodel::class.java)

        var userData = UserData(this).userinfoData
        var token = userData.getString(UserData.TOKEN,"")

        var username = userData.getString(UserData.USER_NAME,"")
        var position = userData.getString(UserData.USER_POSITION,"")
        var department = userData.getString(UserData.USER_DEPARTMENT,"")
        var address = userData.getString(UserData.USER_ADD,"")
        var belong = userData.getString(UserData.USER_BELONG,"")
        var phone = userData.getString(UserData.USER_PHONE,"")
        var email = userData.getString(UserData.USER_EMAIL,"")


        edit_userinfo_name.setText(username)
        edit_userinfo_position.setText(position)
        edit_userinfo_department.setText(department)
        edit_userinfo_address.setText(address)
        edit_userinfo_Belong.setText(belong)
        edit_userinfo_phone.setText(phone)
        edit_userinfo_email.setText(email)


        edit_userinfo_cancelbt.setOnClickListener {
            finish()
        }



        edit_userinfo_Changebt.setOnClickListener {

            username = edit_userinfo_name.text.toString()
            position = edit_userinfo_position.text.toString()
            department = edit_userinfo_department.text.toString()
            address = edit_userinfo_address.text.toString()
            belong = edit_userinfo_Belong.text.toString()
            phone = edit_userinfo_phone.text.toString()
            email = edit_userinfo_email.text.toString()

            val loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)


            Edit_userinfo_Viewmodel.revise(token,username,position,department,address,belong,phone,email).observe(this){

                if(it.Message.isNotEmpty()) {
                    loginviewmodel.tryLogout(
                        UserData(this).userinfoData.getString(
                            UserData.TOKEN,
                            ""
                        )
                    ).observe(this) {

                    }

                    Toast.makeText(this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show()
                    UserData(this).removeUserInfo()
                }
            }

            Edit_userinfo_Viewmodel.getMessage().observe(this){
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }

        }



    }
}