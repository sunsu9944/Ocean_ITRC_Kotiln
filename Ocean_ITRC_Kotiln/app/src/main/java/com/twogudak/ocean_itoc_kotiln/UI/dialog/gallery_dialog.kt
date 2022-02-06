package com.twogudak.ocean_itoc_kotiln.UI.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.*
import com.twogudak.ocean_itoc_kotiln.R

class gallery_dialog(context: Context) {

    val dialog = Dialog(context)
    lateinit var cancelButton : ImageButton
    lateinit var imgtitle : TextView
    lateinit var imgdate : TextView
    lateinit var imglayout : LinearLayout
    lateinit var firstimg : ImageView

    fun status(){
        dialog.setContentView(R.layout.dialog_gallery)
        dialog.setCancelable(true)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        cancelButton = dialog.findViewById(R.id.dialog_gallery_cancelbt)
        imgtitle = dialog.findViewById(R.id.dialog_gallery_title)
        imgdate = dialog.findViewById(R.id.dialog_gallery_date)
        imglayout = dialog.findViewById(R.id.dialog_gallery_layout)
        firstimg = dialog.findViewById(R.id.dialog_gallery_firstimge)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun start(){
        dialog.show()
    }

}