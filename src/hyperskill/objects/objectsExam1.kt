package hyperskill.objects

// Objects → Strings as objects

fun main() {
    val input = readLine()!!
    when (input.takeIf { input.isEmpty() } ?: input.first()) {
        'i' -> println(input.drop(1).toInt() + 1)
        's' -> println(input.drop(1).reversed())
        else -> println(input)
    }

}