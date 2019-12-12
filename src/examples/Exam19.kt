package com.example.hack.examples

fun main() {
    val arrays = arrayOf("one", "two", null)

    for (item in arrays){
        item?.let { println(it) }
    }

    val temp = null

    val temp2 = temp?:100
    println(temp2)
}