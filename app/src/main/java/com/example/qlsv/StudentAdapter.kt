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
import com.example.qlsv.StudentAdapter.myViewHolder

class StudentAdapter(val items: MutableList<StudentModel>): RecyclerView.Adapter<myViewHolder>(){

    class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageAvatar: ImageView = itemView.findViewById(R.id.image_avatar)
        val textHoten: TextView = itemView.findViewById(R.id.text_hoten)
        val textMssv: TextView = itemView.findViewById(R.id.text_mssv)
        val checkSelected: Button = itemView.findViewById(R.id.check_selected)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item, parent, false)
        return myViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val student = items[position]
        holder.imageAvatar.setImageResource(student.avatarResId)
        holder.textHoten.text = student.hoten
        holder.textMssv.text = student.mssv

        holder.checkSelected.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION && holder.adapterPosition < items.size) {
                items.removeAt(holder.adapterPosition)
                notifyItemRemoved(holder.adapterPosition)
                notifyItemRangeChanged(holder.adapterPosition, items.size)
            }
        }
    }



}


