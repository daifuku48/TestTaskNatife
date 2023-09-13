package com.danylokharytonovuaa.testtasknatife.presentation.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain

class GifRecyclerAdapter(
    private val gifList: GifResultDomain
) : RecyclerView.Adapter<GifRecyclerAdapter.ViewHolder>()  {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = gifList.data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}