package com.example.hack

object Game {
    val player = Player("Madrigal",100,true,false)
    var currentRoom: Room = TownSquare()

    init {
        println("Welcome, adventurer.")
        player.castFireBall()
    }

    fun play() {
        while (true) {
            //The game
            println(currentRoom.description())
            println(currentRoom.load())
            printPlayerStatus(player)
            println()
            println("> Enter your command...")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(
        player: Player
    ) {
        println(player.name)
        println("Healths: ${player.healthPoints}")
        println("Aura: ${player.auraVisible}" + " " + "IsBlessed: ${if (player.isBlessed) "YES" else "NO"} ")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { " " })

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
        fun processCommand() = when (command.toLowerCase()) {
            else -> commandNotFound()
        }
    }

}