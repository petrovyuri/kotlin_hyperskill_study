package com.example.hack

fun main() {


    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = auraColor(auraVisible)
    val healthStatus = formatHealthStatus(healthPoints = healthPoints, isBlessed = isBlessed)

    val player = Player()
    player.castFireBall()

    //Состояние игрока
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("Aura: $auraColor" + " " + "\nIsBlessed: ${if (isBlessed) "YES" else "NO"} ")
    println("$name $healthStatus")
}

p


