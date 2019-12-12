package com.example.hack.examples
class Duck1(val size: Int = 17) {
    override fun equals(other: Any?): Boolean {
        return false
    }
    override fun hashCode(): Int {
        return 7
    }
}


fun main(args: Array<String>) {
    val set = setOf(Duck1(), Duck1(17))
    println(set)
}


