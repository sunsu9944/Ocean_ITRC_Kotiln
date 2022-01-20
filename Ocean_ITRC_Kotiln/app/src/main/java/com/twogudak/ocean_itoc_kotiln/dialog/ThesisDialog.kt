package com.twogudak.ocean_itoc_kotiln.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import com.twogudak.ocean_itoc_kotiln.R

class ThesisDialog(context: Context) {

    val dialog = Dialog(context)


    fun status() {

        dialog.setContentView(R.layout.dialog_thesis)
        dialog.setCancelable(false)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        val deletebutton = dialog.findViewById<ImageButton>(R.id.dialog_thesis_delete_button)

        deletebutton.setOnClickListener {
            dialog.dismiss()
        }
    }




    fun start() {
        dialog.show()
    }



}