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
            "create" -> create(mapOfParking, entersUser)
            "status" -> status(mapOfParking)
            "reg_by_color" -> regByColor(mapOfParking, entersUser[1])
            "spot_by_color" -> spotByColor(mapOfParking, entersUser[1])
            "spot_by_reg" -> spotByReg(mapOfParking, entersUser[1])
            "exit" -> running = false
        }
    }
}

fun spotByReg(mapOfParking: MutableMap<Int, String?>, number: String) {
    if (mapOfParking.isNotEmpty()) {
        var isFind = false
        mapOfParking.forEach {
            if (it.value != null) {
                if (it.value!!.contains(number, ignoreCase = true)) {
                    isFind = true
                    println(it.key)
                    return
                }
            }
        }
        if (!isFind) {
            println("No cars with registration number $number were found.")
        }
    } else {
        println("Sorry, parking lot is not created.")
    }
}

fun spotByColor(mapOfParking: MutableMap<Int, String?>, color: String) {
    if (mapOfParking.isNotEmpty()) {
        var isFind = false
        val result = mutableListOf<String>()
        mapOfParking.forEach {
            if (it.value != null) {
                if (it.value!!.contains(color, ignoreCase = true)) {
                    isFind = true
                    result.add(it.key.toString())
                }
            }
        }
        if (!isFind) {
            println("No cars with color $color were found.")
        } else {
            println(result.joinToString())
        }
    } else {
        println("Sorry, parking lot is not created.")
    }
}

fun regByColor(mapOfParking: MutableMap<Int, String?>, color: String) {
    if (mapOfParking.isNotEmpty()) {
        var isFind = false
        val result = mutableListOf<String>()
        mapOfParking.forEach {
            if (it.value != null) {
                if (it.value!!.contains(color, ignoreCase = true)) {
                    isFind = true
                    result.add(it.value!!.split(" ")[0])
                }
            }
        }
        if (!isFind) {
            println("No cars with color $color were found.")
        } else {
            println(result.joinToString())
        }
    } else {
        println("Sorry, parking lot is not created.")
    }
}

fun status(mapOfParking: MutableMap<Int, String?>) {
    if (mapOfParking.isNotEmpty()) {
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
    if (mapOfParking.isNotEmpty()) {
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