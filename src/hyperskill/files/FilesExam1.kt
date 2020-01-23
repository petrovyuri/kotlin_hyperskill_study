package hyperskill.files

import java.io.File

fun main() {
    val fileName = "data/words.txt"
    val listWords = mutableListOf<String>()
    File(fileName).forEachLine {
        listWords.add(it)
    }
    var maxLength = 0
    var maxString = ""
    listWords.forEach {
        if (it.length > maxLength) {
            maxLength = it.length
            maxString = it
        }
    }
    println(maxLength)

}