package com.example.qlsv


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_student_list)
        val editTextHoten = findViewById<EditText>(R.id.hoten)
        val editTextMssv = findViewById<EditText>(R.id.mssv)
        val buttonAdd = findViewById<Button>(R.id.submit)

        val recycler = findViewById<RecyclerView>(R.id.list_students)
        recycler.setHasFixedSize(true)


        val students = mutableListOf<StudentModel>()
        repeat(28) {
            students.add(StudentModel(
                resources.getIdentifier("thumb0", "drawable", packageName),
                "Student $it",
                "SV$it"
            ))
        }

        val adapter = StudentAdapter(students)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter




        buttonAdd.setOnClickListener {
            val hoten = editTextHoten.text.toString()
            val mssv = editTextMssv.text.toString()

            if (hoten.isNotBlank() && mssv.isNotBlank()) {
                val newStudent = StudentModel(
                    hoten = hoten,
                    mssv = mssv,
                    avatarResId = R.drawable.thumb0
                )
                students.add(1,newStudent)
                adapter.notifyItemInserted(1)

                editTextHoten.text.clear()
                editTextMssv.text.clear()
            }
        }



    }
}