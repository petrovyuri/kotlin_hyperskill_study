package hyperskill.math

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val radian = scanner.nextDouble()
    println(Math.sin(radian) - Math.cos(radian))
}