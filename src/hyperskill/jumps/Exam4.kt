package hyperskill.jumps

//Поиск первого числа в строке
fun main() {
    val input = readLine()
    val numbers = "1234567890"
    loop@ for (i in input!!) {
        for (n in numbers) {
            if (i == n) {
                println(i)
                break@loop
            }
        }
    }
}