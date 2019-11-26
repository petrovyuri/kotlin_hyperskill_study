package com.example.hack.examples

class Player(_name: String, val health: Int) {

    val race = "DWARF"
    var town = "Bavaria"
    val name = _name
    lateinit var alignment: String
    private var age = 0

    constructor(_name: String) : this(_name, 100) {
        town = "The Shire"
        println("constructor")
    }

    init {
        println("initializing player")
        alignment = "GOOD"
    }
}

fun main(args: Array<String>) {
    Player("Madrigal")
}
