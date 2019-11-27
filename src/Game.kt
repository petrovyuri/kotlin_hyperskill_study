package com.example.hack

import kotlin.system.exitProcess

object Game {
    val player = Player("Madrigal",100,true,false)
    var currentRoom: Room = TownSquare()

    init {
        //player.castFireBall()
    }

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    private fun move(directionInput: String): String {
        try {
            val direction = Coordinate.Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds")
            }
            val newRoom = worldMap[newPosition.x][newPosition.y]
            player.currentPosition = newPosition
            currentRoom = newRoom
            return "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            return "Invalid direction: $directionInput."
        }
    }

    private fun figth() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }
        "Combat complete"
    } ?: "There's nothing here to fight."

    private fun slay(monster: Fightable.Monster) {
        println("${monster.name} did ${monster.attack(player)} damage!")
        println("${player.name} did ${player.attack(monster)} damage!")
        if (player.healthPoints <= 0) {
            println(">>>> You have been defeated! Thanks for playing. <<<<")
            exitProcess(0)
        }
        if (monster.healthPoints <= 0) {
            println(">>>> ${monster.name} has been defeated! <<<<")
            currentRoom.monster = null
        }
    }

    fun play() {
        while (true) {
            //The game
            println(currentRoom.description())
            println(currentRoom.load())
            printPlayerStatus(player)
            println("> Enter your command...")
            val command = readLine()?.toLowerCase()
            if (command.equals("quit")) {
                println("Quit game")
                break
            } else println(GameInput(command).processCommand())
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
            "move" -> move(argument)
            "map" -> showMap()
            "ring" -> currentRoom.ringBell()
            "figth" -> figth()
            else -> commandNotFound()
        }
    }

    private fun showMap() {
        worldMap.forEach { item ->
            item.forEach {
                if (it.name == (currentRoom.name)) {
                    print("X")
                } else print("O")
            }
            println()
        }
    }

}