package hyperskill.files

import java.io.File

fun main() {
    val list = mutableListOf<String>()
    val string = File("data/text.txt").readText().trim().split(" ")
    println(string.size)
}