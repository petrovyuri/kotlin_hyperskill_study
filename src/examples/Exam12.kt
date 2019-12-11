package com.example.hack.examples

class Exam12(_temp: String) {
    var count = _temp
        get() = field + 2
        set(value) {
            if (value == "s") field = value else field = "nulllllll"
        }

}

fun main() {
    var temp = Exam12("100")
    println(temp.count)
    temp.count = "s"
    println(temp.count)
}