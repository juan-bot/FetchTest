package com.example.fetchapplication.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapplication.R
import com.example.fetchapplication.presentation.model.JsonListModel
import java.lang.Exception

class AdpJsonList(private val list: List<JsonListModel>): RecyclerView.Adapter<AdpJsonList.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_list
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: JsonListModel) {
            val tvName: TextView = itemView.findViewById(R.id.tvName)
            val tvListId: TextView = itemView.findViewById(R.id.tvListId)
            val tvId: TextView = itemView.findViewById(R.id.tvId)

            tvListId.text = "listId: "+info.listId.toString() + ","
            tvName.text = "name: "+info.name + ","
            tvId.text = "id: "+info.id.toString()
        }
    }
}