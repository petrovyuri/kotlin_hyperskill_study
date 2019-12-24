package com.example.hack.learn


typealias DoubleConversion = (Double) -> Double

fun main() {
    //Преобразовать 2.5 кг в фунты
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds").invoke(2.5)}")

    //Определить два лямбда-выражения для преобразований
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    //Два лямбда-выражения преобразуются в одно новое
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)

    //Использовать новое лямбда-выражение для преобразования
    // 17,4 кг в американские тонны
    val value = 17.14
    println("$value kgs is  ${convert(value,kgsToUSTonsLambda)} us tons")


  /*  val kgsToPounds = { x: Double -> x * 2.204623 }
    val poundsToUSTons = { x: Double -> x / 2000.0 }

    val kgsToUSTons = combine(kgsToPounds, poundsToUSTons)
    val usTons = kgsToUSTons.invoke(1000.0)

    println(usTons)*/
}

fun combine(
    lamda1: DoubleConversion,
    lamda2: DoubleConversion
): DoubleConversion {
    return { x: Double -> lamda2(lamda1(x)) }
}


fun convert(
    x: Double,
    converter: DoubleConversion
): Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun convertFive(
    converter: (Int) -> Double
): Double {
    val result = converter(5)
    println("5 is converted $result")
    return result
}

fun getConversionLambda(str: String): DoubleConversion {
    if (str == "CentigradeToFahrenheit") {
        return { it * 1.8 + 32 }
    } else if (str == "KgsToPounds") {
        return { it * 2.2 }
    } else if (str == "PoundsToUSTons") {
        return { it * 2000 }
    } else return { it }
}

