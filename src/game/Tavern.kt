package com.example.hack.game

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"
var patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val menuList = File("data/menu.txt").readText().split("\n")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
var patronGold = mutableMapOf<String, Double>()



fun main() {

    formatMenu()

    //Получение уникального имени
    (0..5).forEach {
        val patron = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$patron $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    // Посетители делают заказ
    uniquePatrons.forEachIndexed { index, patron ->
        println("********** $patron PLACE ORDER*************")
        println("Good evening, $patron  - you're  #${index + 1} in line")

        var orderCount = 0
        while (orderCount < 2) {
            placeOrder(
                patron,
                menuList.shuffled().first()
            )
            orderCount++
        }
    }
    displayPatronBalances()


}

fun perfomPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}


fun formatMenu() {
    println(" *** Welcome to Taernyl's Folly ***")
    var sizeString = 0
    val menuItemList = mutableListOf<List<String>>()
    var sizeNameInMenu = 0
    var setMenu = mutableMapOf<String, List<String>>()

    menuList.forEach { item ->
        val stringItem = item.split(",")
        stringItem.forEach { item ->
            item.trim()
        }
        menuItemList.add(stringItem)
    }
    var lengthName = 30
    menuItemList.forEach { item ->
        var addPoint = 0
        if (item[1].length + item[2].length < lengthName) {
            addPoint = lengthName - (item[1].length + item[2].length)
        }
        var point = StringBuilder()
        for (i in 0..addPoint) {
            point.append(".")
        }


        var valueList = mutableListOf<String>(item[1] + point + item[2])

        try {
            setMenu.getValue(item[0])
            val tempList = setMenu.getValue(item[0]).toMutableList()
            tempList.add(item[1] + point + item[2])
            setMenu.put(item[0], tempList)
        } catch (e: Exception) {
            setMenu.put(item[0], valueList)
        }

    }
    val iterate = setMenu.iterator()
    while (iterate.hasNext()) {
        val list = iterate.next()
        println("~~~~~~~${list.key}~~~~~~")
        list.value.forEach { s: String ->
            var temp = s.replaceFirst(s[0], s[0].toUpperCase())
            println(temp)
        }
    }

    println(" *** End menu ***")
    println()
}


fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")

    val phrase =
        if (name == "Dragon's Breath") {
            "$patronName exclaims: Ah, delicious $name!"
        } else {
            "$patronName says: Thanks for the $name."
        }

    val message = "$patronName buys a $name ($type) for $price"
    println(phrase)
    println(message)
    perfomPurchase(price.toDouble(), patronName)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "1"
            "e", "E" -> "2"
            "i", "I" -> "3"
            "o", "O" -> "4"
            "u", "U" -> "5"
            else -> ""
        }
    }

fun displayPatronBalances (){
    println("*********** Patron's balance ************")
    patronGold.forEach { patron, balance ->
        println("$patron , balance: ${"%.2f".format(balance)}")
    }
}