package com.example.hack.learn

abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)


fun main() {
    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny McGraw")
    val catOwner = PetOwner<Cat>(catFuzz)


    var catVet:Vet<Cat> = Vet<Cat>()
    var dogVet = Vet<Dog>()
    var fishVet = Vet<Fish>()
    val petVet = Vet<Pet>()


    val catContest = Contest<Cat>(petVet)
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatsu, 45)
    val topCat = catContest.getWinners().first()
    println("Top cat is ${topCat.name}")

    val petContest = Contest<Pet>(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 60)
    val topPet = petContest.getWinners().first()
    println("Top Pet is ${topPet.name}")

    val dogRetailer: Retailer<Pet> = DogRetailer()
    dogRetailer.sell()
    petVet.treat(catFuzz)
}


class Contest<T : Pet>(var vet: Vet< in T>) {
    val scores: MutableMap<T, Int> = mutableMapOf()
    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) scores.put(t, score)
    }

    fun getWinners(): MutableSet<T> {
        val highScores = scores.values.max()
        val winners: MutableSet<T> = mutableSetOf()
        for ((t, scores) in scores) {
            if (scores == highScores) winners.add(t)
        }
        return winners
    }
}

class PetOwner<T : Pet>(t: Pet) {
    val pets = mutableListOf(t)


    fun add(t: T) {
        pets.add(t)
    }

    fun remove(t: T) {
        pets.remove(t)
    }

}

interface Retailer<out T> {
    fun sell(): T
}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }
}

class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Fish")
        return Fish("")
    }
}

class Vet<  T : Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}