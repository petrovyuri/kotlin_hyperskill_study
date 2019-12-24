package com.example.hack.examples

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val oneString = scanner.nextLine()
    val twoString = scanner.nextLine()
    val one = oneString.split(" ")
    val two = twoString.split(" ")

    one.forEach { item -> println(item) }
    two.forEach { item -> println(item) }
}