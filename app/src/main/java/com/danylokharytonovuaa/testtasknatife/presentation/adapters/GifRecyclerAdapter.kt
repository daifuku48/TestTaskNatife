package com.danylokharytonovuaa.testtasknatife.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danylokharytonovuaa.testtasknatife.R
import com.danylokharytonovuaa.testtasknatife.domain.model.DataDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain

class GifRecyclerAdapter(
    private val gifList: GifResultDomain
) : RecyclerView.Adapter<GifRecyclerAdapter.ViewHolder>()  {

    var onItemClick: ((DataDomain) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gifView: ImageView

        init{
            gifView = itemView.findViewById(R.id.itemGifView)
            itemView.setOnClickListener {
                onItemClick?.invoke(gifList.data[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gif_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = gifList.data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        Glide.with(holder.gifView.context)
            .asGif()
            .load(gifList.data[position].images.fixedHeightSmall.url)
            .skipMemoryCache(true)
            .override(holder.gifView.width)
            .into(holder.gifView)
    }

}