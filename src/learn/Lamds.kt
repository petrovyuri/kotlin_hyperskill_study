package com.example.hack.learn

fun main(){
    val five = {x:Int -> x+5}
    val result =five.invoke(5)
    println(result)

    val two = {x:Int, y:Int -> x+y}
    println(two.invoke(5,2))
    val myPrint = { "3"}
    println(myPrint.invoke())

    val new:(Int)->Int = {it+5}
    fun convert(x:Double,
                convertor :(Double)->Double):Double{
        val result = convertor(x)
        println("$x is result $result")
        return result
    }

    convert(20.0,{c:Double->c*1.8+32})



}