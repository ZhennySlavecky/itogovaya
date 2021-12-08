package com.zhenny.sensor

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AboutViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    private val aboutNameTextView: TextView = itemView.findViewById(R.id.name_text_view)

    fun bind (name:String) {
        aboutNameTextView.text=name

    }
}

