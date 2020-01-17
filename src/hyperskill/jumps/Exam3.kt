package hyperskill.jumps

import java.util.*
// Двумерные массивы, поиск координат

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val field = Array(5) { Array(5) { "0" } }

    repeat(3) {
        field[scanner.nextInt() - 1][scanner.nextInt() - 1] = "x"
    }
    checkField(field)
}

fun checkField(field: Array<Array<String>>) {
    var x = 0
    var y = 0
    val cellMap = mutableListOf<Int>()
    loop@ for (i in field.indices) {
        for (j in field[i].indices) {
            if (field[i][j] == "x") {
                continue@loop
            }
        }
        cellMap.add(i + 1)
    }

    val rowMap = mutableListOf<Int>()
    loop@ for (i in field.indices) {
        for (j in field.indices) {
            if (field[j][i] == "x") {
                continue@loop
            }
        }
        rowMap.add(i+1)
    }

    println(cellMap.joinToString(" "))
    println(rowMap.joinToString(" "))
}

private fun printField(field: Array<Array<String>>) {
    for (row in field) {
        for (cell in row) {
            print("$cell \t")
        }
        println()
    }
}
