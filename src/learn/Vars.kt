package com.example.hack.learn

fun main() {
    var x = 1
    println("Before while x = $x")
    while (x < 5) {
        x++
        println("After while x = $x")
    }

    var y = 20
    var z = 10
    if (y < z) {
        println("y < z")
    } else {
        println("y > z")
    }
    println("End of IF")

    println(if (y < z) "y < z" else "y > z")

    var x1 =1

    while (x1<2){
        print(if (x1==1)"Yab" else "Dab")
        print("ba")
        x1++
    }
    if (x1==2) println("Do")
}