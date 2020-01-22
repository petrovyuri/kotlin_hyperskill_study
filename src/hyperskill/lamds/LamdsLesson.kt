package hyperskill.lamds

fun main() {
    var funSum = ::sum
    println(funSum.invoke(3, 5))
    val grade = getScoringFunction(true)
    println(grade.invoke(10.0))

    println(applyAndSum(1, 2, ::same))
    println(applyAndSum(4, 4, ::triple))
    println(applyAndSum(2, 2, ::square))

    val originalText = "I don't know... what to say..."
    val textWithoutDots = originalText.filter(::isNotDot)
    println(textWithoutDots)

    val squ = square(10, 10, ::cont)
    println(squ)

    var function = generate("half")
    println(function.invoke(5))

    val checkIsEven = ::isEven
    println(checkIsEven.invoke(4))

    println("Lambdas and syntactic sugar")
    println(originalText.filter { it != '.' })

    println("Complex lambdas")
    val lamdaText = "c"
    println(lamdaText.filter {
        if (!it.isDigit()) {
            return@filter true
        }
        it.toString().toInt() >= 5
    })

    println("Capturing variables")
    var count = 0
    println(count)
    val changeAndPrint = {
        ++count
        println(count)
    }
    changeAndPrint()

    val mul2 = { a: Int, b: Int -> a * b }
    val  increment = placeArgument(5,mul2)
    println(increment(5))

}
fun placeArgument(value: Int, f: (Int, Int) -> Int): (Int) -> Int {
    return { i -> f(value, i) }
}

fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

fun generate(functionName: String): (Int) -> Int {
    if (functionName == "identity") {
        return ::identity
    } else if (functionName == "half") {
        return ::half
    } else return ::zero
}

fun identity(arg: Int): Int = arg
fun half(arg: Int): Int = arg.div(2)
fun zero(arg: Int): Int = 0

fun square(value: Int, context: Any, continuation: (Int, Any) -> Unit) {
    continuation(value * value, context)
}

fun cont(squre: Int, context: Any) = println("ok")

//is predicate
fun isNotDot(c: Char): Boolean = c != '.'

fun applyAndSum(a: Int, b: Int, transformation: (Int) -> Int): Int {
    return transformation(a) + transformation(b)
}

fun same(x: Int) = x

fun square(x: Int) = x * x

fun triple(x: Int) = 3 * x

fun sum(a: Int, b: Int): Int = a + b

fun getRealGrade(x: Double) = x

fun getGradeWithPenalty(x: Double) = x - 1

fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
    if (isCheater) {
        return ::getGradeWithPenalty
    }
    return ::getRealGrade
}
