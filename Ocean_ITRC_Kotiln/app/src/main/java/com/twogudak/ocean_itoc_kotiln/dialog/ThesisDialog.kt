package com.twogudak.ocean_itoc_kotiln.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import com.twogudak.ocean_itoc_kotiln.R
import org.w3c.dom.Text

class ThesisDialog(context: Context) {

    val dialog = Dialog(context)
    var textTitle : TextView? = null
    var text_person: TextView? = null
    var textdate: TextView? = null
    var textbusiness_name: TextView? = null
    var textdepartment: TextView? = null
    var text_origanization: TextView? = null
    var text_support:TextView? = null
    var text_participating:TextView? = null
    var text_search_goal:TextView? = null
    var text_content:TextView? = null
    var text_result_examination:TextView? = null


    fun status() {

        dialog.setContentView(R.layout.dialog_thesis)
        dialog.setCancelable(false)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        textTitle = dialog.findViewById(R.id.dialog_thesis_title)
        text_person = dialog.findViewById(R.id.dialog_thesis_person)
        textdate = dialog.findViewById(R.id.dialog_thesis_date)
        textbusiness_name = dialog.findViewById(R.id.dialog_thesis_Business_name)
        textdepartment = dialog.findViewById(R.id.dialog_thesis_department_name)
        text_origanization = dialog.findViewById(R.id.dialog_thesis_origanization_name)
        text_support = dialog.findViewById(R.id.dialog_thesis_support_name)
        text_participating = dialog.findViewById(R.id.dialog_thesis_participating_name)
        text_search_goal = dialog.findViewById(R.id.dialog_search_goal)
        text_content = dialog.findViewById(R.id.dialog_content_main)
        text_result_examination = dialog.findViewById(R.id.dialog_result_examination)

        val deletebutton = dialog.findViewById<ImageButton>(R.id.dialog_thesis_delete_button)

        deletebutton.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun changetext(textView:TextView?,content:String){
        textView?.text = content
    }


    fun start() {
        dialog.show()
    }



}