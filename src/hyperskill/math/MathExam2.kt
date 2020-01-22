package hyperskill.math

import java.util.*

//Формула Герона,поиск площади треугольника

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()
    val p = (a+b+c)/2
    val result = Math.sqrt(p*(p-a)*(p-b)*(p-c))
    println(result)
}