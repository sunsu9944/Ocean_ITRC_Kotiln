package com.twogudak.ocean_itoc_kotiln.UI.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.twogudak.ocean_itoc_kotiln.R

class result_dialog(context : Context) {

    val dialog = Dialog(context)
    lateinit var cancelButton : ImageButton
    var title : TextView? = null
    var date : TextView? = null
    var member : TextView? = null
    var county : TextView? = null
    var media : TextView? = null
    var category : TextView? = null


    fun status(){
        dialog.setContentView(R.layout.dialog_research_results)
        dialog.setCancelable(false)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        title = dialog.findViewById<TextView>(R.id.dialog_result_title)
        date = dialog.findViewById<TextView>(R.id.dialog_result_date)
        member = dialog.findViewById<TextView>(R.id.dialog_result_member)
        county = dialog.findViewById<TextView>(R.id.dialog_result_country)
        media = dialog.findViewById<TextView>(R.id.dialog_result_media)
        category = dialog.findViewById<TextView>(R.id.dialog_classify)

        cancelButton = dialog.findViewById(R.id.dialog_result_delete)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun start() {
        dialog.show()
    }

}