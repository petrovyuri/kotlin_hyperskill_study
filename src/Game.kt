package com.example.hack

fun main() {

    val player = Player("Madrigal",100,true,false)
    player.castFireBall()

    //Состояние игрока
    printPlayerStatus(player)

}

private fun printPlayerStatus(player: Player
) {
    println("Aura: ${player.auraVisible}" + " " + "IsBlessed: ${if (player.isBlessed) "YES" else "NO"} ")
    println("${player.name} ${player.healthPoints}")
}


