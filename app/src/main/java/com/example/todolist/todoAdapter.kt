package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class todoAdapter (var todos : List<todos>):RecyclerView.Adapter<todoAdapter.todoViewHolder>() {
    inner class todoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return todoViewHolder(view)
    }

    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            val cbDone = findViewById<CheckBox>(R.id.cbDone)

            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}