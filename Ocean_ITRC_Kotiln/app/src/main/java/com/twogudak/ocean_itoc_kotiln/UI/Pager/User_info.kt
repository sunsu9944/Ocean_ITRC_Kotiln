package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Login.LoginActivity
import com.twogudak.ocean_itoc_kotiln.UI.Login.LoginViewModel
import com.twogudak.ocean_itoc_kotiln.UserData
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
            UserData(mainActivity).removeUserInfo()
        }
    }

    override fun onResume() {
        super.onResume()

        var to_login_button = view?.findViewById<Button>(R.id.to_login_button)
        if(mainActivity.checkLogin(mainActivity)){
            to_login_button?.isVisible = false
        } else {
            to_login_button?.isVisible = true
        }

        var logout_button = view?.findViewById<Button>(R.id.logout_button)
        if(mainActivity.checkLogin(mainActivity)){
            logout_button?.isVisible = true
        } else {
            login_button?.isVisible = false
        }



    }


}