package com.example.hack.game

abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

class contest<T : Pet>() {
    var scores: MutableMap<T, Int> = mutableMapOf()

    fun addScores(t: T, score: Int = 0) {
        if (score > 0) scores.put(t, score)
    }

    fun getWinners(): Set<T> {
        val highScore = scores.values.max()
        val winners = scores.filter { it.value == highScore }.keys
        winners.forEach { println("Winners: ${it.name}")}
        return winners
    }
}