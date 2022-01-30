package com.twogudak.ocean_itoc_kotiln.UI.Pager.blackboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.twogudak.ocean_itoc_kotiln.MainActivity
import com.twogudak.ocean_itoc_kotiln.R
import kotlinx.android.synthetic.main.gallery_row.view.*

class gallery : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var imgtitle: Array<String>

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
        imgtitle = mainActivity.imgtitle

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view  = layoutInflater.inflate(R.layout.fragment_gallery,container,false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val galleryAdapter = gallery_Recycler_adapter()
        val galleryrecycler = mainActivity.findViewById<RecyclerView>(R.id.gallery_recyclerView)


        galleryrecycler.adapter = galleryAdapter
        galleryrecycler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


    }


    inner class gallery_Recycler_adapter: RecyclerView.Adapter<gallery_Recycler_adapter.ViewHolderClass>() {

        override fun getItemCount(): Int {
            return 20
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = layoutInflater.inflate(R.layout.gallery_row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

            holder.imgtitle.text = imgtitle[position]
        }


        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            val imgtitle = itemView.row_gallery_title

            override fun onClick(p0: View?) {
                Log.d("test","${adapterPosition}")


            }
        }
    }
}