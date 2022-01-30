package com.twogudak.ocean_itoc_kotiln.UI.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.ImageButton
import com.twogudak.ocean_itoc_kotiln.R

class notice_dialog(context: Context) {

    val dialog = Dialog(context)
    lateinit var cancelButton : ImageButton


    fun status(){
        dialog.setContentView(R.layout.dialog_notice)
        dialog.setCancelable(false)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        cancelButton = dialog.findViewById(R.id.dialog_notice_cancelbt)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun start() {
        dialog.show()
    }

}

