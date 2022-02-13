package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Login.LoginActivity
import com.twogudak.ocean_itoc_kotiln.UI.Login.LoginViewModel
import com.twogudak.ocean_itoc_kotiln.UI.dialog.checkpw_dialog
import com.twogudak.ocean_itoc_kotiln.UserData
import com.twogudak.ocean_itoc_kotiln.httpData.DOMAIN
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_user_info.*


class user_info : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var loginviewmodel : LoginViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_user_info, container, false)

        // Inflate the layout for this fragment
        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var to_login_button = view.findViewById<Button>(R.id.to_login_button)
        loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)

        to_login_button.setOnClickListener {
            var intent = Intent(mainActivity,LoginActivity::class.java)
            startActivity(intent)
        }

        logout_button.setOnClickListener {
            loginviewmodel.tryLogout(UserData(mainActivity).userinfoData.getString(UserData.TOKEN,"")).observe(viewLifecycleOwner){

            }

            Toast.makeText(mainActivity,"로그아웃되었습니다.",Toast.LENGTH_SHORT).show()

            UserData(mainActivity).removeUserInfo()
            to_login_button.isVisible = true
            logout_button.isVisible = false
            userinfo_layout.isVisible = false
            userinfo_button_layout.isVisible = false
        }


        edit_info.setOnClickListener {

            val manager = parentFragmentManager

            Log.e("test","pressbt")
            checkpw_dialog().show(manager, "tag")
        }
    }

    override fun onStart() {
        super.onStart()
        var userData = UserData(mainActivity).userinfoData

        var to_login_button =mainActivity.findViewById<Button>(R.id.to_login_button)
        var logout_button = mainActivity.findViewById<Button>(R.id.logout_button)
        var userinfo = mainActivity.findViewById<LinearLayout>(R.id.userinfo_layout)
        var userinfo_layout = mainActivity.findViewById<LinearLayout>(R.id.userinfo_button_layout)

        if(mainActivity.checkLogin(mainActivity)){
            //로그인이 되어있을
            to_login_button.isVisible = false
            logout_button.isVisible = true
            userinfo.isVisible = true
            userinfo_layout.isVisible = true

            userinfo_username.text = userData.getString(UserData.USER_NAME,"")
            userinfo_userID.text = userData.getString(UserData.USER_ID,"")
            userinfo_userEmail.text = userData.getString(UserData.USER_EMAIL,"")
            userinfo_userBelong.text = userData.getString(UserData.USER_BELONG,"")
            userinfo_userDepartment.text = userData.getString(UserData.USER_DEPARTMENT,"")
            userinfo_userAddress.text = userData.getString(UserData.USER_ADD,"")
            userinfo_userPhone.text = userData.getString(UserData.USER_PHONE,"")
            val imageurl = userData.getString(UserData.USER_IMAGE,"")

            val imgURL = "${DOMAIN.IMAGE_LOAD_URL}${imageurl}"
            Glide.with(mainActivity).load(imgURL)
                .error(Glide.with(mainActivity).load(R.drawable.defaultimg))
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(userinfo_userimage)


        } else {
            //로그인이 안되어있을
            to_login_button.isVisible = true
            logout_button.isVisible = false
            userinfo.isVisible = false
            userinfo_layout.isVisible = false
        }
    }


}