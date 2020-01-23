package hyperskill.math

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextDouble()
    val string = input.toString().split(".")
    println(string[1].toCharArray()[0])

}