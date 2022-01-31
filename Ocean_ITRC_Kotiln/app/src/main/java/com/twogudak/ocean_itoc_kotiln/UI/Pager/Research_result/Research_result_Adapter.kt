package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_result

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.result_dialog
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchResultsDTO

class Research_result_Adapter(var context: Context, var ResearchResults: List<ResearchResultsDTO>) : RecyclerView.Adapter<Research_result_Adapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            return ResearchResults.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = LayoutInflater.from(context).inflate(R.layout.resaerch_result_row,parent,false)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)




            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.title.text = "${ResearchResults[position].title_ko}"
            holder.number.text = "${ResearchResults[position].rrid}"
            holder.date.text = "${ResearchResults[position].date}"
            holder.manager.text = "${ResearchResults[position].writer_ko}"
            holder.maincontent.text = ""
        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            var title = itemView.findViewById<TextView>(R.id.row_result_title)
            var number = itemView.findViewById<TextView>(R.id.row_result_number)
            var date = itemView.findViewById<TextView>(R.id.row_result_date)
            var manager = itemView.findViewById<TextView>(R.id.row_result_name)
            var maincontent = itemView.findViewById<TextView>(R.id.row_result_textcontent)


            override fun onClick(p0: View?) {

                Log.d("test","${adapterPosition}")

                val dia = result_dialog(context)
                dia.status()
                dia.title?.text = "${ResearchResults[adapterPosition].title_ko}"
                dia.category?.text = "${ResearchResults[adapterPosition].classify_ko}"
                dia.date?.text = "${ResearchResults[adapterPosition].date}"
                dia.member?.text = "${ResearchResults[adapterPosition].writer_ko}"
                dia.county?.text = "${ResearchResults[adapterPosition].announe_nation_ko}"
                dia.media?.text = "${ResearchResults[adapterPosition].media_ko}"
                dia.start()


            }


        }

    }
