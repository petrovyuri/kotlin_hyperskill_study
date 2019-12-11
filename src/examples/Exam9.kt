package com.example.hack.examples

class TapeDeck {
    var hasRecorder = false
    fun playTape() {
        println("Tape playing")
    }
    fun recordTape() {
        if (hasRecorder) {
            println ("Tape recording")
        }
    }
}
fun main(args: Array<String>) {
    val  t = TapeDeck()
    t.hasRecorder = true
    t.playTape()
    t.recordTape()
}