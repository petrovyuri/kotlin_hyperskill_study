package com.example.hack.examples

class BadException : Exception()

fun main(){
    myFunction("No")
}

fun myFunction(test: String) {
    try {
        print("t")
        print("h")
        riskyCode(test)
    } catch (e: BadException) {
        print("r")
        print("o")
    } finally {
        print("w")
        print("s")
    }

}


fun riskyCode(test: String) {
    if (test == "Yes") {
      throw BadException()
    }
    print("a")

}

