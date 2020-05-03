package com.example.kotlin_todo_list

import java.util.*

data class Item (
    val mId: String = UUID.randomUUID().toString(),
    val mName: String
)