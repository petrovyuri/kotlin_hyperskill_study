package hyperskill.jumps

import java.util.*

// Поиск уникальных букв в строке
fun main() {
    val scanner = Scanner(System.`in`)
    val input = scanner.next()
    var count = 0
    for (item in input) {
        if (input.count { it == item } == 1) {
            count++
        }
    }
    println(count)
}