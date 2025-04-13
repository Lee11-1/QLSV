package com.example.qlsv

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button


class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_student_list)
        val listView = findViewById<ListView>(R.id.list_students)
        val editTextHoten = findViewById<EditText>(R.id.hoten)
        val editTextMssv = findViewById<EditText>(R.id.mssv)
        val buttonAdd = findViewById<Button>(R.id.submit)

        val students = mutableListOf<StudentModel>()
        repeat(28) {
            students.add(StudentModel(
                resources.getIdentifier("thumb0", "drawable", packageName),
                "Student $it",
                "SV$it"
            ))
        }

        val adapter = StudentAdapter(students)

        val listStudents = findViewById<ListView>(R.id.list_students)
        listStudents.adapter = adapter




        buttonAdd.setOnClickListener {
            val hoten = editTextHoten.text.toString()
            val mssv = editTextMssv.text.toString()

            if (hoten.isNotBlank() && mssv.isNotBlank()) {
                val newStudent = StudentModel(
                    hoten = hoten,
                    mssv = mssv,
                    avatarResId = R.drawable.thumb0
                )
                students.add(newStudent)
                adapter.notifyDataSetChanged()

                editTextHoten.text.clear()
                editTextMssv.text.clear()
            }
        }

    }
}