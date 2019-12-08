package com.example.hack.examples

fun main(args: Array<String>) {
    var x = 10
    while (x > 1) {
        x--
        print(if (x < 3) "small x" else "")
    }
}
