package com.example.hack.tasks

fun main() {
    val list = arrayOf(5, 2, 3)
    var all = list.reduce { item1, item2 ->
        item1 + item2
    }
    println(all)
}