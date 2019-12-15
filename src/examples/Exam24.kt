package com.example.hack.examples

val mercedes = true
val red = false
val enoughMoney = true

val buyCar = enoughMoney && (!mercedes || red)

val y = 1

fun main(){
    println(buyCar)
}