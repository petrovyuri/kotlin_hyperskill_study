package hyperskill.parking_lot

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var running = true
    val mapOfParking = mutableMapOf<Int, String?>()
    for (i in 1..20) {
        mapOfParking[i] = null
    }
    while (running) {
        val entersUser = scanner.nextLine().split(" ")
        when (entersUser[0]) {
            "park" -> park(mapOfParking, entersUser)
            "leave" -> leave(mapOfParking, entersUser)
            "exit" -> running = false
        }
    }
}

fun leave(mapOfParking: MutableMap<Int, String?>, entersUser: List<String>) {
    val spot = entersUser[1].toInt()
    mapOfParking[spot] = null
    println("Spot $spot is free.")
}

fun park(mapOfParking: MutableMap<Int, String?>, entersUser: List<String>) {
    val numberCar = entersUser[1]
    val colorCar = entersUser[2]
    mapOfParking.forEach {
        if (it.value == null) {
            mapOfParking[it.key] = numberCar
            println("$colorCar car parked on the spot ${it.key}.")
            return
        }
    }
    println("Sorry, parking lot is full.")
}






