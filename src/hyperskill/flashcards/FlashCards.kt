package hyperskill.flashcards

data class Card(val numberCard: Int,
                val termin: String,
                val define: String) {
}


fun main() {
    println("Input the number of cards:")
    val needCards = readLine()?.toInt()
    val listCards = mutableListOf<Card>()
    addCards(needCards, listCards)
    runGame(listCards)
}

private fun addCards(needCards: Int?, listCards: MutableList<Card>) {
    for (i in 1..needCards!!) {
        println("The card #$i:")
        var termin = readLine()
        termin = checkInputTermin(listCards, termin)
        println("The definition of the card #$i:")
        var define = readLine()
        define = checkInputDefine(listCards, define)
        listCards.add(Card(i, termin!!, define!!))
    }
}

fun checkInputDefine(listCards: MutableList<Card>, _define: String?): String? {
    var result = _define
    while (listCards.count { card -> card.define == result } != 0) {
        println("The definition \"$result\" already exists. Try again:")
        result = readLine()
    }
    return result
}

private fun checkInputTermin(listCards: MutableList<Card>, _termin: String?): String? {
    var result = _termin
    while (listCards.count { card -> card.termin == result } != 0) {
        println("The card \"$result\" already exists. Try again:")
        result = readLine()
    }
    return result
}

private fun runGame(listCards: MutableList<Card>) {
    listCards.forEach {
        println("Print the definition of \"${it.termin}\"")
        val input = readLine()
        if (input == it.define) {
            println("Correct answer.")
        } else {
            println(checkAnswer(listCards, it, input))
        }
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

