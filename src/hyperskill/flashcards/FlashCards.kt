package hyperskill.flashcards

import java.io.File
import java.util.*

data class Card(
    var termin: String,
    var define: String
)
fun main() {
    val listCards = mutableListOf<Card>()
    var run = true
    while (run) {
        println("Input the action (add, remove, import, export, ask, exit):")
        when (readLine()) {
            "add" -> addCard(listCards)
            "remove" -> removeCard(listCards)
            "import" -> importCards(listCards)
            "export" -> exportCards(listCards)
            "ask" -> runGame(listCards)
            "exit" -> run = false
        }
    }
    println("Bye bye!")
}

fun exportCards(listCards: MutableList<Card>) {
    println("File name:")
    val file = File(readLine())
    val string = StringBuilder()
    listCards.forEach {
        string.append("${it.termin}-${it.define}")
        string.append("\n")
    }
    file.writeText(string.toString())
    println("${listCards.size} cards have been saved.")
}

private fun importCards(listCards: MutableList<Card>) {
    println("File name:")
    val file = File(readLine())
    var count = 0
    if (file.exists()) {
        file.forEachLine {
            for (i in 0..listCards.lastIndex) {
                if (listCards[i].termin == it.split("-")[0]) {
                    listCards[i].define = it.split("-")[1]
                    count++
                    return@forEachLine
                }
            }
            listCards.add(Card(it.split("-")[0], it.split("-")[1]))
            count++
        }
        println("$count cards have been loaded.")
    } else {
        println("File not found.")
    }

}

private fun removeCard(listCards: MutableList<Card>) {
    println("The card:")
    val needCardRemove = readLine()
    if (listCards.removeIf {
            it.termin == needCardRemove
        }) {
        println("The card has been removed.")
    } else println("Can't remove \"$needCardRemove\": there is no such card.")
}


private fun addCard(listCards: MutableList<Card>) {
    println("The card:")
    val termin = checkInputTermin(listCards, readLine())
    if (termin == "bad") {
        return
    }
    println("The definition of the card:")
    val define = checkInputDefine(listCards, readLine())
    if (define == "bad") {
        return
    }
    listCards.add(Card(termin, define))
    println("The pair (\"$termin\":\"$define\") has been added.")
}

fun checkInputDefine(listCards: MutableList<Card>, _define: String?): String {
    while (listCards.count { card -> card.define == _define } != 0) {
        println("The definition \"$_define\" already exists. Try again:")
        return "bad"
    }
    return _define!!
}

private fun checkInputTermin(listCards: MutableList<Card>, _termin: String?): String {
    while (listCards.count { card -> card.termin == _termin } != 0) {
        println("The card \"$_termin\" already exists.")
        return "bad"
    }
    return _termin!!
}

private fun runGame(listCards: MutableList<Card>) {
    println("How many times to ask?")
    val count = readLine()
    repeat(count!!.toInt()) {
        val currentCard = listCards[Random().nextInt(listCards.size)]
        println(
            "Print the definition of " +
                    "\"${currentCard.termin}\""
        )
        val input = readLine()
        if (currentCard.define == input) {
            println("Correct answer.")
        } else println(checkAnswer(listCards, currentCard, input))
    }
}

fun checkAnswer(listCards: MutableList<Card>, card: Card, input: String?): Any? {
    listCards.forEach {
        if (input == it.define) {
            return "Wrong answer. The correct one is \"${card.define}\", you've just written the definition of \"${it.termin}\"."
        }
    }
    return "Wrong answer. The correct one is \"${card.define}\""
}