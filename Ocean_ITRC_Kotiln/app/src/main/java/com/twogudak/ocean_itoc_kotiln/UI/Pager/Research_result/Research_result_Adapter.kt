package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.result_dialog

class Research_result_Adapter(var context: Context) : RecyclerView.Adapter<Research_result_Adapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            return 30
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = LayoutInflater.from(context).inflate(R.layout.resaerch_result_row,parent,false)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {


        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


            override fun onClick(p0: View?) {

                Log.d("test","${adapterPosition}")

                val dia = result_dialog(context)
                dia.status()
                dia.title?.text = "연구 성에서 클릭 ${adapterPosition}번째 자료"
                dia.start()


            }


        }

    }
}