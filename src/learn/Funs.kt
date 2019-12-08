package com.example.hack.learn

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    var userChoice = getUserChoice(options)

    println("GameChoice: $gameChoice")
    println("UserChoice: $userChoice")

    printResult(gameChoice, userChoice)

}

fun printResult(gameChoice: String, userChoice: String) {

    if (userChoice == gameChoice) {
        println("Draw")
    } else if ((userChoice == "Scissors" && gameChoice == "Paper") ||
        (userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock")
    ) {
        println("You Win")
    } else println(" You Lose")
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = true
    var userChoice = ""

    while (isValidChoice) {
        val inputUser = readLine()?.capitalize()

        if (inputUser != null && inputUser in optionsParam) {
            userChoice = inputUser
            isValidChoice = false
        } else println("Repeat please")
    }
    return userChoice
}
