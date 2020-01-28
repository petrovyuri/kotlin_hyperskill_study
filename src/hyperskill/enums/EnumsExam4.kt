package hyperskill.enums

import java.util.*

enum class Rainbow2(val color: String, val rgb: String) {
    RED("red", "#FF0000"),
    ORANGE("orange", "#FF7F00"),
    YELLOW("yellow", "#FFFF00"),
    GREEN("green", "#00FF00"),
    BLUE("blue", "#0000FF"),
    INDIGO("indigo", "#4B0082"),
    VIOLET("violet", "#8B00FF");

    companion object {
        fun check(string: String): Int? {
            return (values().find { it.color == string }?.ordinal)?.plus(1)
        }
    }

}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Rainbow2.check(input.next()))
}
