package com.example.hack.examples

import com.intellij.refactoring.util.duplicates.Match
import kotlin.random.Random

fun unless(condition:Boolean, code:) {
    if (!condition) {
        code()
    }
}

fun main(args: Array<String>) {
    val options = arrayOf("Red", "Amber", "Green")
    var crossWalk = options[Random(options.size).nextInt()]
    if (crossWalk == "Green") {
        println("Walk!")
    }
    unless (crossWalk == "Green") { println("Stop!") }
}