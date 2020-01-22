package hyperskill.doubles

import java.util.*
import java.util.Locale.US

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`).useLocale(US)
    val density = scanner.nextDouble()
    val height = scanner.nextDouble()
    println(density * 9.8 * height)
}