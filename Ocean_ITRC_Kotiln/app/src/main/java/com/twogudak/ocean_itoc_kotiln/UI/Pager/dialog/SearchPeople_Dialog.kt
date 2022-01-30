package com.twogudak.ocean_itoc_kotiln.UI.Pager.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.twogudak.ocean_itoc_kotiln.R

class SearchPeople_Dialog(context: Context) {

    val dialog = Dialog(context)

    var peopleimg : ImageView? = null
    var peoplename : TextView? = null
    var people_department : TextView? = null
    var people_rol : TextView? = null
    var people_phonenumber : TextView? = null
    var people_email : TextView? = null

    lateinit var cancelButton : ImageButton

    fun status(){
        dialog.setContentView(R.layout.research_people)
        dialog.setCancelable(false)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        cancelButton = dialog.findViewById(R.id.dismissbt)
        peopleimg = dialog.findViewById(R.id.select_research_people_img)
        peoplename = dialog.findViewById(R.id.select_research_people_name)
        people_department = dialog.findViewById(R.id.select_research_people_department)
        people_rol = dialog.findViewById(R.id.select_research_people_role)
        people_phonenumber = dialog.findViewById(R.id.select_research_people_phonenumber)
        people_email = dialog.findViewById(R.id.select_research_people_email)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun start() {
        dialog.show()
    }

    fun changetext(textView:TextView? ,name:String){
        textView?.text = name
    }


}