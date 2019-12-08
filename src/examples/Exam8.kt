package com.example.hack.examples

class DrumKit(val hasTopHat: Boolean, var hasSnare: Boolean) {


    fun playTopHat() {
        if (hasTopHat) {
            println("ding ding ba-da-bing!")
        }
    }

    fun playSnare() {
        if (hasSnare) {
            println("bang bang bang!")
        }

    }
}

fun main(){
    val d= DrumKit(true,true)
    d.playTopHat()
    d.playSnare()
    d.hasSnare = false
    d.playTopHat()
    d.playSnare()
}