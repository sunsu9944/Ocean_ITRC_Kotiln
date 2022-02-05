package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.GalleryDTO
import kotlinx.android.synthetic.main.gallery_row.view.*

class GalleryAdapter(var context: Context,var Gallerydata : GalleryDTO?) : RecyclerView.Adapter<GalleryAdapter.ViewHolderClass>() {

    //item 갯수
    override fun getItemCount(): Int {
        if(Gallerydata?.db_data.isNullOrEmpty()){
            return 0
        }
        return Gallerydata?.db_data!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

        val itemView = LayoutInflater.from(context).inflate(R.layout.gallery_row,parent,false)
        val holder = ViewHolderClass(itemView)
        itemView.setOnClickListener(holder)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        holder.rowTitle.text = "${Gallerydata!!.db_data[position].title_ko}"
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val rowImage = itemView.row_gallery_img
        val rowTitle = itemView.row_gallery_title

        override fun onClick(p0: View?) {

        }


    }
}