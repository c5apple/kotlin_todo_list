package com.example.kotlin_todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // Initialize Adapter
        val adapter = RecyclerAdapter(this, this, ArrayList())

        bt_add_item.setOnClickListener {
            if ( !TextUtils.isEmpty( et_item.text.toString() ) ) {
                val task = Item( mName = et_item.text.toString() )
                adapter.addListItem(task)
            } else {
                Snackbar.make(container, "Task is empty", Snackbar.LENGTH_SHORT).show();
            }
            et_item.setText("")
        }

        mainRecyclerView.adapter = adapter

        // 区切り線の表示
        mainRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}