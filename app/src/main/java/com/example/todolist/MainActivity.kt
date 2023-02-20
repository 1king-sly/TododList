package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var rvTodos:RecyclerView
    lateinit var btnAdd:Button
    lateinit var etTodos:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvTodos = findViewById(R.id.rvTodos)
        btnAdd = findViewById(R.id.btnAdd)
        etTodos = findViewById(R.id.etTodos)
        val todoList = mutableListOf(
            todos("Go to Supermarket",true)
        )
        val adapter = todoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val title = etTodos.text.toString()
            val todo = todos(title,false)
            todoList.add(todo)
            adapter.notifyItemChanged(todoList.size-1)
            etTodos.text.clear()
        }
    }
}