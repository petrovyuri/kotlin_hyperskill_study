package com.example.hack

class Player {

    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false


    var name = "madrigal"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    fun castFireBall(numFireBalls: Int = 2) {
        println("A glass of Fireball springs into existence. (x$numFireBalls)")
    }

    private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String =
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

    private fun auraColor(auraVisible: Boolean): String {
        val auraColor = if (auraVisible) "Green" else "NONE"
        return auraColor
    }
}