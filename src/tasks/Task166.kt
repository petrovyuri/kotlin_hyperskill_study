package tasks


import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

//var playerGold = 10
//var playerSilver = 10
var playerDragon = 5.0


fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    placePints()
}

fun placePints() {
    val pint = 0.125
    val barrel = 5
    val drankPints = pint * 12
    val remainInBarrel = barrel - drankPints
    println("Remain pints: $remainInBarrel gallons")
}

fun performPurchase(price: Double): Boolean {
    displayBalance()
    //val totalPurse = playerGold + (playerSilver / 100.0)
    val totalPurse = playerDragon * 1.43
    println("Total purse: ${"%.2f".format(totalPurse)}")
    println("Purchasing item for $price")

    if (totalPurse >= price) {
        val remainingBalance = totalPurse - price
        println("Remaining balance: ${"%.2f".format(remainingBalance)}")
        //val remainingGold = remainingBalance.toInt()
        //val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
        //playerGold = remainingGold
        //playerSilver = remainingSilver
        playerDragon= remainingBalance / 1.43
        displayBalance()
        return true
    } else {
        println("Madrigal does not have enough many")
        displayBalance()
    }
    return false
}

fun displayBalance(remain: Double) {

}

fun displayBalance() {
    println("Player's purse balance: Dragon: $playerDragon")

}

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")

    val phrase =
        if (name == "Dragon's Breath") {
            "Madrigal exclaims Ah, delicious $name!"
        } else {
            "Madrigal says: Thanks for the $name."
        }


    val message = "Madrigal buys a $name ($type) for $price."


    if (performPurchase(price.toDouble())) {
        println(phrase)
        println(message)
    }
}

/*fun checkPrice(price: Double): Boolean {
    val totalPurce = playerGold + (playerSilver / 100)
    return totalPurce >= price
}*/

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
