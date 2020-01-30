package hyperskill.calculator


import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var exit = false
    loop@ while (!exit) {
        val input = scanner.nextLine().split(" ")
        if (input[0].contains("/") || input[0].isEmpty()) {
            when (input[0]) {
                "" -> continue@loop
                "/exit" -> {
                    println("Bye!")
                    exit = true
                }
                "/help" -> println("The program calculates the sum of numbers")
                else -> println("Unknown command")
            }
        } else {
            try {
                calc(input)
            } catch (e: Exception) {
                println("Invalid expression")
            }
        }
    }
}

private fun calc(input: List<String>) {
    var result = 0
    var oldResult = 1
    if (Regex("[a-z]").containsMatchIn(input[0])) throw Exception("Error")

    input.forEach {
        when {
            Regex("""\d+""").containsMatchIn(it) -> {
                result += oldResult * it.toInt()
                oldResult = 1
            }

            it.contains('-') -> if (it.length % 2 !== 0) oldResult = -1
        }
    }

    println(result)
}

