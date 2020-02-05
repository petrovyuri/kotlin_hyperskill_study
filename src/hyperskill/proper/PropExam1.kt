package hyperskill.proper

class City(val name: String) {
    var degrees: Int = 0
        get() {
            if (field < -91 || field > 57) {
                when (name) {
                    "Dubai" -> field = 30
                    "Moscow" -> field = 5
                    "Hanoi" -> field = 20
                }
            }
            return field
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    if (firstCity.degrees == secondCity.degrees
        || firstCity.degrees == thirdCity.degrees
        || secondCity.degrees == thirdCity.degrees) {
        println("neither")
    } else {
        println(when (minOf(firstCity.degrees,
            secondCity.degrees,
            thirdCity.degrees)) {
            firstCity.degrees -> "Dubai"
            secondCity.degrees -> "Moscow"
            else -> "Hanoi"
        })
    }

}