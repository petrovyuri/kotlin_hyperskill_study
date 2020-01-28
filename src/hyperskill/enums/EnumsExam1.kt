package hyperskill.enums

enum class DangerLevel(private val int: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel():Int{
        return this.int
    }

}

fun main() {
    val high = DangerLevel.HIGH
    val medium = DangerLevel.MEDIUM
    println(high.getLevel() > medium.getLevel())
}