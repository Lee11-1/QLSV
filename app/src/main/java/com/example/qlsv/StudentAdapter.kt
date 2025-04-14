package com.example.qlsv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val items: List<StudentModel>): RecyclerView.Adapter<StudentAdapter.myViewHolder>(){

    class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageAvatar: ImageView = itemView.findViewById((R.id.image_avatar))
        val textHoten: TextView = itemView.findViewById((R.id.hoten))
        val textMssv: TextView = itemView.findViewById(R.id.mssv)
        val checkSelected: Button = itemView.findViewById(R.id.check_selected)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item, parent, false)
        return myViewHolder(itemView)
    }

    override fun getItemCount() : Int = items.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.imageAvatar.setImageResource(items[position].avatarResId)
        holder.textHoten.text = items[position].hoten
        holder.textMssv.text = items[position].mssv
    }


}