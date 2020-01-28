package hyperskill.enums

import java.util.Scanner

enum class Dict(private val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar");


    companion object {
        fun check(country1: String, country2: String) :Boolean{
            return (values().find { it.name == country1 }?.currency
                    == values().find { it.name == country2 }?.currency)
        }
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Dict.check(input.next(), input.next()))
}