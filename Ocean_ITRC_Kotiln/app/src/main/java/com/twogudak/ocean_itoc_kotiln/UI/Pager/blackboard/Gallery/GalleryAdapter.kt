package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard.Gallery

import android.app.ActionBar
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.graphics.scaleMatrix
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.twogudak.ocean_itoc_kotiln.R
import com.twogudak.ocean_itoc_kotiln.UI.dialog.gallery_dialog
import com.twogudak.ocean_itoc_kotiln.httpData.DOMAIN
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.GalleryDTO
import kotlinx.android.synthetic.main.gallery_row.view.*

class GalleryAdapter(var context: Context,var Gallerydata : GalleryDTO?) : RecyclerView.Adapter<GalleryAdapter.ViewHolderClass>() {

    var imgnames: ArrayList<ArrayList<String>> = ArrayList(ArrayList())

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

        var imgname:ArrayList<String> = ArrayList()

        for(item in Gallerydata!!.db_data){
            val stringdata =  item.img_src.split("\"")
            for(name in stringdata){
                if(name.contains("jpg")) imgname.add(name)
            }
            imgnames.add(imgname)
            imgname = ArrayList()
        }


        Log.e("test",imgnames.toString())
        if(imgnames.size >= Gallerydata!!.db_data.size && !imgnames[position].isEmpty()) {
            val imgURL = "${DOMAIN.Gallery_LOAD_URL}${imgnames[position][0]}"

            Glide.with(context).load(imgURL)
                .error(Glide.with(context).load(R.drawable.defaultimg))
                .fallback(R.drawable.defaultimg)
                .placeholder(R.drawable.defaultimg)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.rowImage)
        }

    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val rowImage = itemView.row_gallery_img
        val rowTitle = itemView.row_gallery_title

        override fun onClick(p0: View?) {

            val dialog = gallery_dialog(context)
            dialog.status()

            dialog.imgtitle.text = Gallerydata!!.db_data[adapterPosition].title_ko
            dialog.imgdate.text = Gallerydata!!.db_data[adapterPosition].gDate


            if(imgnames.size >= Gallerydata!!.db_data.size && !imgnames[adapterPosition].isEmpty()) {
                val imgURL = "${DOMAIN.Gallery_LOAD_URL}${imgnames[adapterPosition][0]}"

                Glide.with(context).load(imgURL)
                    .error(Glide.with(context).load(R.drawable.defaultimg))
                    .fallback(R.drawable.defaultimg)
                    .placeholder(R.drawable.defaultimg)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(dialog.firstimg)
            }



            for(i in imgnames[adapterPosition].indices){
                val imgview :ImageView = ImageView(context,)
                if(imgnames.size >= Gallerydata!!.db_data.size && !imgnames[adapterPosition].isEmpty()) {

                    val imgURL = "${DOMAIN.Gallery_LOAD_URL}${imgnames[adapterPosition][i]}"
                    val param = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    param.setMargins(30,0,30,0)
                    param.gravity = Gravity.CENTER_VERTICAL
                    param.width = 1000
                    param.height = 600

                    Log.e("test",imgURL)
                    Glide.with(context).load(imgURL)
                        .error(Glide.with(context).load(R.drawable.defaultimg))
                        .fallback(R.drawable.defaultimg)
                        .placeholder(R.drawable.defaultimg)
                        .skipMemoryCache(false)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(imgview)
                    imgview.layoutParams = param
                    dialog.imglayout.addView(imgview)
                }

            }
            dialog.start()

        }


    }
}