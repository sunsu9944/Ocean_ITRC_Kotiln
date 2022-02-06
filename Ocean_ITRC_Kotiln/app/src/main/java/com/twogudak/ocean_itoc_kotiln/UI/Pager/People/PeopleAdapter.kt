package com.twogudak.ocean_itoc_kotiln.UI.Pager.People

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.SearchPeople_Dialog
import com.twogudak.ocean_itoc_kotiln.httpData.DOMAIN
import com.twogudak.ocean_itoc_kotiln.httpData.Members.MemberDTO
import kotlinx.android.synthetic.main.researchpeople_row.view.*

class PeopleAdapter(var context: Context, var memberList: MemberDTO?,): RecyclerView.Adapter<PeopleAdapter.ViewHolderClass>() {



    override fun getItemCount(): Int {

        if(memberList?.memberlist.isNullOrEmpty()){
            return 0
        }


        return memberList?.memberlist!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

        val itemView = LayoutInflater.from(context).inflate(R.layout.researchpeople_row,parent,false)
        val holder = ViewHolderClass(itemView)
        itemView.setOnClickListener(holder)


        return holder
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        holder.rowName.text = "${memberList!!.memberlist[position].name_ko}"
        holder.rowposition.text = "${memberList!!.memberlist[position].position_ko}"
        val imgURL = "${DOMAIN.IMAGE_LOAD_URL}${memberList!!.memberlist[position].photo}"
        Glide.with(context).load(imgURL)
            .error(Glide.with(context).load(R.drawable.defaultimg))
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.rowImageView)
    }


    inner class ViewHolderClass(itemView: View ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        val rowImageView = itemView.research_people_img
        val rowName = itemView.research_people_textView
        val rowposition = itemView.people_role

        override fun onClick(p0: View?) {

            Log.d("test","${adapterPosition}")
            val dia = SearchPeople_Dialog(context)

            dia.status()
            dia.changetext(dia.peoplename,"${memberList!!.memberlist[adapterPosition].name_ko}")
            dia.changetext(dia.people_rol,"${memberList!!.memberlist[adapterPosition].position_ko}")
            dia.changetext(dia.people_department,"${memberList!!.memberlist[adapterPosition].department_ko}")
            dia.changetext(dia.people_phonenumber,"${memberList!!.memberlist[adapterPosition].phone}")
            dia.changetext(dia.people_email,"${memberList!!.memberlist[adapterPosition].email}")
            val imgURL = "${DOMAIN.IMAGE_LOAD_URL}${memberList!!.memberlist[position].photo}"
            Glide.with(context).load(imgURL)
                .error(Glide.with(context).load(R.drawable.defaultimg))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(dia.peopleimg!!)

            dia.start()

        }
    }
}
