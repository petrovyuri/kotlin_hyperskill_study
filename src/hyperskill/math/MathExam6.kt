package hyperskill.math

import java.util.*

// Решение квадратного уравнения
fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()
    val discriminant = (b * b) - 4.0 * a * c
    var counRoot = 0
    if (discriminant == 0.0) {
        counRoot = 1
    } else if (discriminant > 0.0) {
        counRoot = 2
    }
    when (counRoot) {
        2 -> twoRootFind(a, b, c, discriminant)
        1 -> oneRootFind(a, b, c, discriminant)
        0 -> println("Нет корней")
    }
}

fun oneRootFind(a: Double, b: Double, c: Double, discriminant: Double) {
    var root = ((-b) + Math.sqrt(discriminant)) / 2 * a
    println("$root")
}

fun twoRootFind(a: Double, b: Double, c: Double, discriminant: Double) {
    val root1 = ((-b) + Math.sqrt(discriminant)) / (2.0 * a)
    val root2 = ((-b) - Math.sqrt(discriminant)) / (2.0 * a)
    println("${Math.min(root1, root2)} ${Math.max(root1, root2)}")
}
