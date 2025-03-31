package com.example.qlsv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val studentList: MutableList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.editTextText)
        val textViewID: TextView = view.findViewById(R.id.editTextNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.textViewName.text = student.name
        holder.textViewID.text = student.studentID
    }

    override fun getItemCount() = studentList.size

    fun addStudent(student: Student) {
        studentList.add(student)
        notifyItemInserted(studentList.size - 1)
    }
}
