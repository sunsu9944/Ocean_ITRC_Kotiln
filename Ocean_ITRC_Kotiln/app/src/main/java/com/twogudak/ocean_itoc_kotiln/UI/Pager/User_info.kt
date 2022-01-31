package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.Login.LoginActivity


class user_info : Fragment() {

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
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var to_login_button = view.findViewById<Button>(R.id.to_login_button)

        to_login_button.setOnClickListener {
            var intent = Intent(mainActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}