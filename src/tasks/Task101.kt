package tasks

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = auraColor(auraVisible)
    val healthStatus = formatHealthStatus(healthPoints = healthPoints, isBlessed = isBlessed)

    //Состояние игрока
    println("**********************************")
    printPlayerStatus(auraColor, isBlessed, name, healthStatus, castFireball(45))


}

fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String,
    castFireball: String
) {

    println("Aura: $auraColor" + ", " + "IsBlessed: ${if (isBlessed) "YES" else "NO"}, $castFireball")
    println("$name $healthStatus")
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("Aura: $auraColor" + ", " + "IsBlessed: ${if (isBlessed) "YES" else "NO"} ")
    println("$name $healthStatus")
}

private fun auraColor(auraVisible: Boolean): String =
    if (auraVisible) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> " has a few scratches."
        in 75..89 -> {
            if (isBlessed) "has some minor wounds but is healing quite quickly!"
            else " has some minor wounds."
        }
        in 15..74 -> " has some minor wounds."
        else -> " is in awful condition!"
    }


private fun castFireball(numFireballs: Int = 2): String {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    val s = when (numFireballs) {
        in 1..10 -> "навеселе"
        in 11..20 -> "выпивший"
        in 21..30 -> "пьяный"
        in 31..40 -> "сильно пьяный"
        in 41..50 -> "в стельку"
        else -> ""
    }
    return s
}
