package com.example.hack.examples

fun main() {
    val friuts = arrayOf("Apple", "Banana", "Cherry", "Blueberry", "Pomegranate")
    val index = arrayOf(1, 2, 3, 4)

    var y: Int
    var x = 0


    while (x < 4) {
        y = index[x]
        println("Fruit = ${friuts[y]}")
        x++
    }

}