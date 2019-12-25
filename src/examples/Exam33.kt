package com.example.hack.examples

data class Pizza(val name: String, val pricePerSlice: Double, val quantity: Int)

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3, 4, 5)
    val pizzas = listOf(
        Pizza("Sunny Chicken", 4.5, 4),
        Pizza("Goat and Nut", 4.0, 1),
        Pizza("Tropical", 3.0, 2),
        Pizza("The Garden", 3.5, 3)
    )

    val minInt = ints.min()
    val minInt2 = ints.min()

    //pizzas.forEach { println(it.name) }

    /* pizzas.filter { it.quantity>2 }
         .forEach { println(it.name) }*/

    var itemName = ""
    /* pizzas.forEach {
         itemName+=it.name
         println("Item name: $itemName")
     }*/
    pizzas.forEach { itemName += it.name }
    println(itemName)

}
