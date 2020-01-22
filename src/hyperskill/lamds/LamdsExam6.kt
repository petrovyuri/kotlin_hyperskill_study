package hyperskill.lamds

fun main() {
    var originalPredicate: (Char) -> Boolean = { it == '.' }
    val notPredicate: (Char) -> Boolean = {
        if (originalPredicate(it)) false
        else true
    }
}