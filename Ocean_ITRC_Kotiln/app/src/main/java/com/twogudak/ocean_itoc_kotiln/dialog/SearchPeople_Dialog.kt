package com.twogudak.ocean_itoc_kotiln.dialog

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.twogudak.ocean_itoc_kotiln.R

class SearchPeople_Dialog(context: Context) {

    val dialog = Dialog(context)

    lateinit var peopleimg : ImageView
    var peoplename : TextView? = null
    lateinit var cancelButton : ImageButton

    fun status(){
        dialog.setContentView(R.layout.research_people)
        dialog.setCancelable(false)

        cancelButton = dialog.findViewById(R.id.dismissbt)
        peoplename = dialog.findViewById(R.id.select_research_people_name)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun start() {
        dialog.show()
    }

    fun changetextname(name:String){
        peoplename?.text = name
    }


}