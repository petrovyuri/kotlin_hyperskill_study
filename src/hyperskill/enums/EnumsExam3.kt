package hyperskill.enums

import java.util.*

enum class Rainbow(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF");

    companion object {
        fun check(string: String): Boolean {
            return ((values().find { it.color.toLowerCase() == string }?.color?.toLowerCase()) == string)
        }
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Rainbow.check(input.next().toLowerCase()))
}