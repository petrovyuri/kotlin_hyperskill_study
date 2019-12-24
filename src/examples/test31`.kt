package com.example.hack.examples

fun main(args: Array<String>) {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "lb", 3.0),
        Grocery("Mushrooms", "Vegetable", "lb", 4.0),
        Grocery("Bagels", "Bakery", "Pack", 1.5),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0),
        Grocery("Ice cream", "Frozen", "Pack", 3.0)
    )
    println("Expensive ingredients:")
    searchNew(groceries) { x: Grocery -> x.unitPrice > 5.0 }

    println("All vegetables:")
    searchNew(groceries) { x: Grocery -> x.category == "Vegetable" }

    println("All packs:")
    searchNew(groceries) { x: Grocery -> x.unit == "Pack" }
}

fun searchNew(
    list: List<Grocery>,
    function: (Grocery) -> Boolean
) {
    for (item in list) {
        if (function(item)) {
            println(item.name)
        }
    }
}

