package com.example.hack.examples

data class Grocery2(
    val name: String, val category: String,
    val unit: String, val unitPrice: Double, val quantity: Int
)

fun main(args: Array<String>) {
    val groceries = listOf(
        Grocery2("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery2("Mushrooms", "Vegetable", "lb", 4.0, 1),
        Grocery2("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery2("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery2("Ice cream", "Frozen", "Pack", 3.0, 2)
    )

    var maxGrocery = groceries.maxBy { it.unitPrice }
    println(maxGrocery?.name)


    var array = arrayOf(1,7,4,3)
    println(array.min())

    val sumGrocery2 = groceries.sumByDouble { it.quantity * it.unitPrice}
    println(sumGrocery2)
}


