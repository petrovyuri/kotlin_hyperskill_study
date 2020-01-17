package com.example.hack.game

import java.io.File

class Player(
    _name: String,
    _healthPoints: Int,
    _isBlessed: Boolean,
    _isImmortal: Boolean
) : Fightable {
    override var diceCount = 3
    override var diceSides = 6
    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    var currentPosition = Coordinate(0, 0)
    var hometown = selectHometown()
    var isBlessed = _isBlessed
    override var healthPoints = _healthPoints
    var isImmortal = _isImmortal
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = auraColor(auraVisible)
    var name = _name
        get() = "${field.capitalize()} from ${hometown}"
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

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

}