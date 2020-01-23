package hyperskill.files

import java.io.File

fun main() {
    val regex = Regex("0|1|2|3|4|5|6|7|8|9")
    val listNumbers = mutableListOf<String>()
    File("data/numbers.txt").forEachLine {
        if (regex.containsMatchIn(it)) {
            listNumbers.add(it)
        }
    }
    println(listNumbers.size)

    val listNumbers2 = mutableListOf<Int>()
    File("data/numbers.txt").forEachLine {
        try {
            listNumbers2.add(it.toInt())
        } catch (e: Exception) {

        }
    }
    println(listNumbers2.size)

}