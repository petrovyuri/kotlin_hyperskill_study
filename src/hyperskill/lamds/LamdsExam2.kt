package hyperskill.lamds

fun main() {
    val a = 10
    val b = 20
    val c = 5

    val lambda: (Int) -> Int = {
        a * (it * it)+b*it+c
    }

    println(lambda(2))
}

