package com.example.hack

fun main() {
    //Двоичный вывод
    println(Integer.toBinaryString(127))



    println(playerCreateMessage(nameIsLong("Polarcubis, Supreme Master of NyetHack")))


    "Polarcubis, Supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)

}

fun nameIsLong(name: String) = name.length >= 20

fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too long. Please choose another name."
    } else {
        "Welcome, adventurer"
    }
}