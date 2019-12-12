package com.example.hack.learn

import java.io.PrintStream
import java.io.PrintWriter


fun main() {
    myFunction("o")
}
fun myFunction(str: String) {

    try {
        val x = str.toInt()
        println(x)
        println("myFunction has ended")
    } catch (e: MyException) {
        println(".kjlkjlkj")
    }


}
class MyException : Exception() {
    override fun printStackTrace() {
        println("SUPER")
    }

    override fun printStackTrace(p0: PrintStream?) {
        println("SUPER")
    }

    override fun printStackTrace(p0: PrintWriter?) {
        println("SUPER")
    }
}

