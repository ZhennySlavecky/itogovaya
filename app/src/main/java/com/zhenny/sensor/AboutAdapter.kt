package com.zhenny.sensor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AboutAdapter (private val aboutNames: List<String>):
    RecyclerView.Adapter<AboutViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.about_list_item, parent, false)
        return AboutViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        val name = aboutNames[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return aboutNames.size
    }


}