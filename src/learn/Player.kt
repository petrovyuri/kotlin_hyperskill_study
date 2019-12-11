package com.example.hack.learn

class Player(val title: String, val artist: String) {
    var title2: String = title
        get() = title + "11111"
        set(value) {
             field = value
        }

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
    player2.play()

    println(player1.title2)
    player1.title2 = "5"
    println(player1.title2)
}