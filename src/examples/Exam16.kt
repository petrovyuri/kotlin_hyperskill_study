package com.example.hack.examples

abstract class Appliance {
    val pluggedIn = true
    abstract val color:String
    abstract fun consumePower()
}

class CoffeMaker:Appliance(){
    override val color = " "
    var coffeeLeft = false
    override fun consumePower() {
        println("Consuming power")
    }
    fun fillWithWater() {
        println("Fill with water")
    }

    fun makeCoffee() {
        println("Make the coffee")
    }

}