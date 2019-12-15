package com.example.hack.learn

fun main(args: Array<String>) {
    var addFive = { x: Int -> x + 5 }
    println("Pass 6 to addFive: ${addFive(6)}")
    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts.invoke(6, 7)
    println("Pass 6, 7 to addInts: $result")
    val intLambda: (Int, Int) -> Int = { x, y -> x * y }
    println("Pass 10, 11 to intLambda: ${intLambda(10, 11)}")
    val addSeven: (Int) -> Int = { it + 7 }
    println("Pass 12 to addSeven: ${addSeven(12)}")
    val myLambda: () -> Unit = { println("Hi!") }
    myLambda()

    fun convert(
        x: Double,
        convertor: (Double) -> Double
    ): Double {
        val result = convertor(x)
        println("$x is konverted $result")
        return result

    }

    fun convertFive(convertor: (Int) -> Double): Double {
        val result = convertor(5)
        println("5 is $result")
        return result
    }

    convert(20.0) { it * 1.8 + 32 }
    convertFive { 5.2 }


}