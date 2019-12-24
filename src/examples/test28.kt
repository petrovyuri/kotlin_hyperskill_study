package com.example.hack.examples


fun main() {

    val x = 20
    val y = 2.3


    val lam1 = { x: Int -> x }
    println(lam1(x + 6))
}