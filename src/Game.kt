package com.example.hack

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "Green" else "NONE"


    val healthStatus =
        formatHealthStatus(healthPoints, isBlessed)

    //Состояние игрока
    println("Aura: $auraColor" + " " + "\nIsBlessed: ${if (isBlessed) "YES" else "NO"} ")
    println("$name $healthStatus")

}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> " has a few scratches."
            in 75..89 -> {
                if (isBlessed) "has some minor wounds but is healing quite quickly!"
                else " has some minor wounds."
            }
            in 15..74 -> " has some minor wounds."
            else -> " is in awful condition!"
        }
    return healthStatus
}