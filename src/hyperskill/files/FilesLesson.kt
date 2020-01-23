package hyperskill.files

import java.io.File

fun main() {
    val fileName ="data/menu.txt"
    val lines = File(fileName).readText()
    println(lines)
}