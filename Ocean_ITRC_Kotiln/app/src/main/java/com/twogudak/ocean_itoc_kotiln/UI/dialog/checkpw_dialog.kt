package com.twogudak.ocean_itoc_kotiln.UI.dialog

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.twogudak.ocean_itoc_kotiln.UI.Pager.UserInfo.Edit_info.Edit_userinfo
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UserData
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.CheckPwRespository
import kotlinx.android.synthetic.main.dialog_checkpw.*


class checkpw_dialog : DialogFragment() {

    lateinit var mainActivity: MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isCancelable = false
        mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_checkpw, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog_checkpw_cancelbt.setOnClickListener {
            dismiss()
        }

        dialog_checkpw_checkbt.setOnClickListener {
            val token =  UserData(mainActivity).userinfoData.getString(UserData.TOKEN,"")

            CheckPwRespository().checkPw(dialog_checkpw_Edit.text.toString(),token).observe(viewLifecycleOwner){

                Log.e("test",it.Message)

                if(it.Message == "실패하였습니다."){
                    var intent = Intent(mainActivity, Edit_userinfo::class.java)
                    dismiss()
                    startActivity(intent)

                }
            }

            CheckPwRespository().message.observe(viewLifecycleOwner){
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }


    }


}