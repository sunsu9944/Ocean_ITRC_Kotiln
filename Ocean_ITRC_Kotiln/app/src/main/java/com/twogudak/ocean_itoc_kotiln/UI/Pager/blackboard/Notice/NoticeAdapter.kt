package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Notice

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.notice_dialog
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.NoticeDTO

class NoticeAdapter(var context: Context, var noticeData:NoticeDTO?): RecyclerView.Adapter<NoticeAdapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            if(noticeData?.db_data.isNullOrEmpty()){
                return 0
            }
            return noticeData?.db_data!!.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = LayoutInflater.from(context).inflate(R.layout.notice_row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

            holder.row_notice_number.text = noticeData!!.db_data[position].qid
            holder.row_notice_title.text = noticeData!!.db_data[position].title
            holder.row_notice_admin.text = noticeData!!.db_data[position].userName
            holder.row_notice_date.text = noticeData!!.db_data[position].date

        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            val row_notice_number = itemView.findViewById<TextView>(R.id.row_notice_number)
            val row_notice_title = itemView.findViewById<TextView>(R.id.row_notice_title)
            val row_notice_admin = itemView.findViewById<TextView>(R.id.row_notice_admin)
            val row_notice_date = itemView.findViewById<TextView>(R.id.row_notice_date)


            override fun onClick(p0: View?) {
                Log.d("test","${adapterPosition}")

                val dialog = notice_dialog(context)
                dialog.status()

                dialog.admin.text = noticeData!!.db_data[adapterPosition].qid
                dialog.title.text = noticeData!!.db_data[adapterPosition].title
                dialog.content.text = noticeData!!.db_data[adapterPosition].content
                dialog.date.text = noticeData!!.db_data[adapterPosition].date

                dialog.start()
            }
        }
    }
