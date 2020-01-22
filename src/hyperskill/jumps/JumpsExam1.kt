package hyperskill.jumps
// Перебор алфавита
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val string = "abcdefghijklmnopqrstuvwxyz"
    val enter = input.next()

    loop@ for (i in string.indices) {
        for (j in enter.indices) {
            if (string[i] == enter[j]) continue@loop
        }
        print(string[i])
    }
}