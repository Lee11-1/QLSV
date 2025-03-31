package com.example.qlsv

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextID: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextText)
        editTextID = findViewById(R.id.editTextNumber)
        buttonSubmit = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recyclerView)

        studentAdapter = StudentAdapter(mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val id = editTextID.text.toString()
            if (name.isNotEmpty() && id.isNotEmpty()) {
                studentAdapter.addStudent(Student(name, id))
                editTextName.text.clear()
                editTextID.text.clear()
            }
        }
    }
}
