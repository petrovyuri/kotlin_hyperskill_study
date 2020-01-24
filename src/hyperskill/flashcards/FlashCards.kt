package hyperskill.flashcards

import java.io.File
import java.util.*

data class Card(
    var termin: String,
    var define: String,
    var errors: Int = 0

)

private var listLogs = mutableListOf<String>()
private val listCards = mutableListOf<Card>()
private var mapArgs = mutableMapOf<String, String>()

fun main(args: Array<String>) {
    var run = true
    getArgsToMap(args)
    loadCards()
    while (run) {
        printlnAndSaveLog("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
        when (readLineAndSaveLog()) {
            "add" -> addCard()
            "remove" -> removeCard()
            "import" -> importCards()
            "export" -> exportCards()
            "hardest card" -> printHardestCard()
            "reset stats" -> resetStats()
            "log" -> saveLogToFile()
            "ask" -> runGame()
            "exit" -> {
                printlnAndSaveLog("Bye bye!")
                saveCards()
                run = false
            }
        }
    }
}

private fun getArgsToMap(args: Array<String>) {
    if (args.size in 1..2) {
        if (args[0] == "-import") {
            mapArgs["-import"] = args[1]
        } else {
            mapArgs["-export"] = args[1]
        }
    } else if (args.size > 2) {
        if (args[0] == "-import") {
            mapArgs["-import"] = args[1]
            mapArgs["-export"] = args[3]
        } else {
            mapArgs["-import"] = args[3]
            mapArgs["-export"] = args[1]
        }
    }
}

private fun saveCards() {
    if (mapArgs.containsKey("-export")) {
        val file = File(mapArgs["-export"])
        val string = StringBuilder()
        listCards.forEach {
            string.append("${it.termin}-${it.define}-${it.errors}")
            string.append("\n")
        }
        file.writeText(string.toString())
        printlnAndSaveLog("${listCards.size} cards have been saved.")
    }
}

private fun loadCards() {
    if (mapArgs.containsKey("-import")) {
        File(mapArgs["-import"]).readLines().forEach {
            listCards.add(Card(it.split("-")[0], it.split("-")[1], it.split("-")[2].toInt()))
        }
        printlnAndSaveLog("${listCards.size} cards have been loaded.")
    }
}

private fun saveLogToFile() {
    printlnAndSaveLog("File name:")
    val logs: (List<String>) -> String = {
        var string = ""
        it.forEach {
            string += "$it \n"
        }
        string
    }
    File(readLineAndSaveLog()).writeText(logs.invoke(listLogs))
    printlnAndSaveLog("The log has been saved.")
}

private fun resetStats() {
    listCards.forEach {
        it.errors = 0
    }
    printlnAndSaveLog("Card statistics has been reset.")
}

private fun printHardestCard() {
    var maxError = 0
    listCards.forEach {
        if (it.errors > maxError) {
            maxError = it.errors
        }
    }
    val arrayMaxErrorsCards = arrayListOf<String>()
    listCards.forEach {
        if (it.errors == maxError) {
            arrayMaxErrorsCards.add(it.termin)
        }
    }
    if (maxError == 0) {
        printlnAndSaveLog("There are no cards with errors")
    } else {
        if (arrayMaxErrorsCards.size > 1) {
            printlnAndSaveLog(
                "The hardest cards are \"${arrayMaxErrorsCards.joinToString()}\"." +
                        " You have $maxError errors answering them."
            )
        } else {
            printlnAndSaveLog(
                "The hardest card is \"${arrayMaxErrorsCards.joinToString()}\"." +
                        " You have $maxError errors answering it."
            )
        }

    }
}

private fun <T> Iterable<T>.joinToString(separator: CharSequence = "\", \"", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((T) -> CharSequence)? = null): String {
    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
}

private fun readLineAndSaveLog(): String {
    val input = readLine()
    input?.let { listLogs.add(it) }
    return input!!
}

private fun printlnAndSaveLog(any: Any) {
    listLogs.add(any.toString())
    println(any)
}

private fun exportCards() {
    printlnAndSaveLog("File name:")
    val file = File(readLineAndSaveLog())
    val string = StringBuilder()
    listCards.forEach {
        string.append("${it.termin}-${it.define}-${it.errors}")
        string.append("\n")
    }
    file.writeText(string.toString())
    printlnAndSaveLog("${listCards.size} cards have been saved.")
}

private fun importCards() {
    printlnAndSaveLog("File name:")
    val file = File(readLineAndSaveLog())
    var count = 0
    if (file.exists()) {
        file.forEachLine {
            for (i in 0..listCards.lastIndex) {
                if (listCards[i].termin == it.split("-")[0]) {
                    listCards[i].define = it.split("-")[1]
                    listCards[i].errors = it.split("-")[2].toInt()
                    count++
                    return@forEachLine
                }
            }
            listCards.add(Card(it.split("-")[0], it.split("-")[1], it.split("-")[2].toInt()))
            count++
        }
        printlnAndSaveLog("$count cards have been loaded.")
    } else {
        printlnAndSaveLog("File not found.")
    }

}

private fun removeCard() {
    printlnAndSaveLog("The card:")
    val needCardRemove = readLineAndSaveLog()
    if (listCards.removeIf {
            it.termin == needCardRemove
        }) {
        printlnAndSaveLog("The card has been removed.")
    } else printlnAndSaveLog("Can't remove \"$needCardRemove\": there is no such card.")
}


private fun addCard() {

    printlnAndSaveLog("The card:")
    val termin = checkInputTermin(listCards, readLineAndSaveLog())
    if (termin == "bad") {
        return
    }
    printlnAndSaveLog("The definition of the card:")
    val define = checkInputDefine(listCards, readLineAndSaveLog())
    if (define == "bad") {
        return
    }
    listCards.add(Card(termin, define))
    printlnAndSaveLog("The pair (\"$termin\":\"$define\") has been added.")
}

private fun checkInputDefine(listCards: MutableList<Card>, _define: String?): String {
    while (listCards.count { card -> card.define == _define } != 0) {
        printlnAndSaveLog("The definition \"$_define\" already exists. Try again:")
        return "bad"
    }
    return _define!!
}

private fun checkInputTermin(listCards: MutableList<Card>, _termin: String?): String {
    while (listCards.count { card -> card.termin == _termin } != 0) {
        printlnAndSaveLog("The card \"$_termin\" already exists.")
        return "bad"
    }
    return _termin!!
}

private fun runGame() {
    printlnAndSaveLog("How many times to ask?")
    val count = readLineAndSaveLog()
    repeat(count.toInt()) {
        val currentCard = listCards[Random().nextInt(listCards.size)]
        printlnAndSaveLog(
            "Print the definition of " +
                    "\"${currentCard.termin}\""
        )
        val input = readLineAndSaveLog()
        if (currentCard.define == input) {
            printlnAndSaveLog("Correct answer.")
        } else {
            printlnAndSaveLog(checkAnswer(currentCard, input))
            currentCard.errors++
        }
    }
}

private fun checkAnswer(card: Card, input: String?): String {
    listCards.forEach {
        if (input == it.define) {
            return "Wrong answer. The correct one is \"${card.define}\", you've just written the definition of \"${it.termin}\"."
        }
    }
    return "Wrong answer. The correct one is \"${card.define}\""
}

