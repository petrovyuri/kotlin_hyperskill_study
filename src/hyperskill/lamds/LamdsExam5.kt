package hyperskill.lamds

fun main() {
    val lambda: (Int, Int) -> Int = { a, b ->
        if (a > b) a
        else b
    }
    println(lambda.invoke(9, 5))
}

