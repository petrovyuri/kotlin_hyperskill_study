package hyperskill.doubles

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()
    val d = scanner.nextDouble()
    println(a * 10.5 + b * 4.4 + (c + d) / 2.2)
}