package hyperskill.math

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val v1a = scanner.nextDouble()
    val v1b = scanner.nextDouble()
    val v2a = scanner.nextDouble()
    val v2b = scanner.nextDouble()
    val scalar = (v1a * v2a) + (v1b * v2b)
    val modV1 = (v1a * v1a) + (v1b * v1b)
    val modV2 = (v2a * v2a) + (v2b * v2b)
    val arccos = Math.acos(scalar / Math.sqrt(modV1 * modV2))
    println(Math.round(arccos / 3.14 * 180))
}