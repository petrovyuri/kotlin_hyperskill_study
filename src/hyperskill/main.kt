import kotlin.math.roundToInt

fun main() {
    val leatherCase = LeatherCase(190, "brown")
    val softCase = SoftCase(120, "yellow")
    val woodCase = WoodCase(230, "orange")
    println(getCaseTax(leatherCase) + getCaseTax(softCase) + getCaseTax(woodCase))
}

open class Case(val cost: Int) {
    fun getFullInfo(): String = "$$cost cost" + getTax()

    open fun getTax(): Int = (cost * 0.25).roundToInt()
}

open class SoftCase(cost: Int, val color: String) : Case(cost) {
    override fun getTax(): Int = super.getTax() + 100
}

open class WoodCase(cost: Int, val color: String) : Case(cost)

open class LeatherCase(cost: Int, color: String) : SoftCase(cost, color) {
    override fun getTax(): Int = (cost * 0.35).roundToInt()
}

fun getCaseTax(case: Case): Int = case.getTax()