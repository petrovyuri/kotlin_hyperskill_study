package parking

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    var running = true
    var mapOfParking = mutableMapOf<Int, String?>()

    while (running) {
        val entersUser = scanner.nextLine().split(" ")
        when (entersUser[0]) {
            "park" -> park(mapOfParking, entersUser)
            "leave" -> leave(mapOfParking, entersUser)
            "exit" -> running = false
            "create" -> create(mapOfParking, entersUser)
            "status" -> status(mapOfParking)
        }
    }
}

fun status(mapOfParking: MutableMap<Int, String?>) {
    if(mapOfParking.isNotEmpty()){
        var isEmptyPark = true
        mapOfParking.forEach {
            if (it.value != null) {
                isEmptyPark = false
            }
        }
        if (isEmptyPark) {
            println("Parking lot is empty.")
        } else {
            mapOfParking.forEach {
                if (it.value != null) {
                    println("${it.key} ${it.value}")
                }
            }
        }
    } else {
        println("Sorry, parking lot is not created.")
    }
}

private fun create(mapOfParking: MutableMap<Int, String?>, entersUser: List<String>) {
    mapOfParking.clear()
    for (i in 1..entersUser[1].toInt()) {
        mapOfParking[i] = null
    }
    println("Created a parking lot with ${mapOfParking.size} spots.")
}

fun leave(mapOfParking: MutableMap<Int, String?>, entersUser: List<String>) {
    if(mapOfParking.isNotEmpty()){
        val spot = entersUser[1].toInt()
        if (mapOfParking[spot] == null) {
            println("There is no car in the spot $spot.")
        } else {
            mapOfParking[spot] = null
            println("Spot $spot is free.")
        }
    } else {
        println("Sorry, parking lot is not created.")
    }
}

fun park(mapOfParking: MutableMap<Int, String?>, entersUser: List<String>) {
    val numberCar = entersUser[1]
    val colorCar = entersUser[2]
    if (mapOfParking.isNotEmpty()) {
        mapOfParking.forEach {
            if (it.value == null) {
                mapOfParking[it.key] = "$numberCar $colorCar"
                println("$colorCar car parked on the spot ${it.key}.")
                return
            }
        }
        println("Sorry, parking lot is full.")
    } else println("Sorry, parking lot is not created.")
}