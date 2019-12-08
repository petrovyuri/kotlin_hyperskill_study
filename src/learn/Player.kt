package com.example.hack.learn

import com.example.hack.displayPatronBalances

class Player(val title: String, val artist: String) {
    fun play() {
        println("Play $title  artist $artist")
    }

    fun stop() {
        println("Stop $title artist $artist")
    }
}

fun main() {
    val player1 = Player("first", "art1")
    val player2 = Player("second", "art2")

    player1.play()
    player1.stop()
}