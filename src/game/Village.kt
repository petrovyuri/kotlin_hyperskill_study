package com.example.hack.game

fun main() {
    runSimulation()
}

fun runSimulation(){
    val greetinFunction = configureGreetingFunction()
    println(greetinFunction("Oleg"))
    println(greetinFunction("Yura"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}


fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction coast: ${cost * numBuildings}")
}

