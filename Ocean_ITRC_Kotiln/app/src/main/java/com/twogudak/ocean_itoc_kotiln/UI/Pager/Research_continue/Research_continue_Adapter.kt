package com.twogudak.ocean_itoc_kotiln.UI.Pager.Research_continue

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.ThesisDialog
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.ResearchContinueDTO
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Research_continue_Adapter(var context:Context,var Research_continue:List<ResearchContinueDTO>?): RecyclerView.Adapter<Research_continue_Adapter.ViewHolderClass>(),Filterable {

    //필터링 구현
    val unFilteredList = Research_continue // 필터전 데이터
    var filteredList = Research_continue  //필터링 중인 데이터

    //현재시간
    var dateFormat = SimpleDateFormat("yyyy-MM-dd")
    var currendDate = dateFormat.parse(dateFormat.format(Date()))

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charString = p0.toString()

                //시간별로 구현할 것임
                filteredList = if (charString.isEmpty()) {
                    Log.e("test","0000")
                    unFilteredList
                }else if(charString == "1"){
                    var filteringList = ArrayList<ResearchContinueDTO>()

                    if (unFilteredList != null) {
                        for (item in unFilteredList) {
                            //진행중 과제
                            Log.e("test","1111")
                            if(currendDate.compareTo(dateFormat.parse(item.date_end))<0) filteringList.add(item)
                        }
                    }
                    filteringList
                } else {
                    var filteringList = ArrayList<ResearchContinueDTO>()

                    if (unFilteredList != null) {
                        for (item in unFilteredList) {
                            //완료 과제
                            Log.e("test","2222")
                            if(currendDate.compareTo(dateFormat.parse(item.date_end))>=0) filteringList.add(item)
                        }
                    }
                    filteringList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults //필터링 된 데이터
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as ArrayList<ResearchContinueDTO>?

                    notifyDataSetChanged()
            }
        }
    }

    //리사이클뷰의 갯
    override fun getItemCount(): Int {
        if (filteredList.isNullOrEmpty()){
            return 0
        } else {
            return filteredList!!.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

        val itemView = LayoutInflater.from(context).inflate(R.layout.resaerch_result_row,parent,false)
        val holder = ViewHolderClass(itemView)
        itemView.setOnClickListener(holder)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        holder.research_Continue_title.text = "${filteredList!![position].research_name_ko}"
        holder.research_number.text = "${filteredList!![position].rfid}"
        holder.date.text = "${filteredList!![position].date_start} ~ ${filteredList!![position].date_end}"
        holder.content.text = "${filteredList!![position].research_content_ko}"
        holder.name.text = "${filteredList!![position].research_manager_ko}"
    }


    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val research_Continue_title = itemView.findViewById<TextView>(R.id.row_result_title)
        val research_number = itemView.findViewById<TextView>(R.id.row_result_number)
        val date = itemView.findViewById<TextView>(R.id.row_result_date)
        val content = itemView.findViewById<TextView>(R.id.row_result_textcontent)
        val name = itemView.findViewById<TextView>(R.id.row_result_name)


        override fun onClick(p0: View?) {
            Log.d("test","${adapterPosition}")

            val dia = ThesisDialog(context)
            dia.status()
            dia.textTitle?.text = "${Research_continue!![adapterPosition].research_name_ko}"
            dia.text_person?.text = "${Research_continue!![adapterPosition].research_manager_ko}"
            dia.textdate?.text = "${Research_continue!![adapterPosition].date_start} ~ ${Research_continue!![adapterPosition].date_end}"
            dia.textbusiness_name?.text = "${Research_continue!![adapterPosition].business_name_ko}"
            dia.textdepartment?.text = "${Research_continue!![adapterPosition].department_name_ko}"
            dia.text_origanization?.text = "${Research_continue!![adapterPosition].subjectivity_agency_ko}"
            dia.text_support?.text = "${Research_continue!![adapterPosition].support_agency_ko}"
            dia.text_participating?.text = "${Research_continue!![adapterPosition].participation_agency_ko}"
            dia.text_search_goal?.text = "${Research_continue!![adapterPosition].research_goal_ko}"
            dia.text_content?.text = "${Research_continue!![adapterPosition].research_content_ko}"
            dia.text_result_examination?.text = "${Research_continue!![adapterPosition].expectation_result_ko}"

            dia.start()
        }
    }
}
