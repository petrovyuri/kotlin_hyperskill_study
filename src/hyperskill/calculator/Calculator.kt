package hyperskill.calculator

import java.util.*
import kotlin.math.pow

private var variablesMap = mutableMapOf<String, Int>()
private lateinit var input: String
private var inputsList = mutableListOf<String>()
private var stack = mutableListOf<String>()
private var queue = mutableListOf<String>()
private var expressionList = mutableListOf<String>()

fun main() {
    val scanner = Scanner(System.`in`)
    loop@ while (true) {
        initLoop(scanner)
        if (inputsList[0].isEmpty() || input.first() == '/') {
            when (inputsList[0]) {
                "" -> continue@loop
                "/exit" -> {
                    println("Bye!")
                    break@loop
                }
                "/help" -> println("The program calculates the sum of numbers")
                else -> println("Unknown command")
            }
        } else if (Regex("[^\\w ^=]").containsMatchIn(input)) {
            try {
                calcExpression()
            } catch (e: Exception) {
                println("Invalid expression")
            }
        } else {
            initVars()
        }
    }
}

private fun calcExpression() {
    parseInput()
    getPostFixEx()
    calcResult()
}

private fun initLoop(scanner: Scanner) {
    input = scanner.nextLine()
    inputsList = input.split(" ") as MutableList<String>
    stack.clear()
    queue.clear()
    expressionList.clear()
}

private fun calcResult() {
    val stack = mutableListOf<Int>()
    for (item in queue) {
        when {
            Regex("[\\da-zA-Z]").containsMatchIn(item) -> {
                if (variablesMap.containsKey(item)) {
                    stack.add(variablesMap.getValue(item))
                } else stack.add(item.toInt())
            }
            item == "+" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] + stack.last()
                stack.removeAt(stack.lastIndex)
            }
            item == "*" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] * stack.last()
                stack.removeAt(stack.lastIndex)
            }
            item == "/" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] / stack.last()
                stack.removeAt(stack.lastIndex)
            }
            item == "-" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] - stack.last()
                stack.removeAt(stack.lastIndex)
            }
            item == "^" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1].toDouble().pow(stack.last()).toInt()
                stack.removeAt(stack.lastIndex)
            }
        }
    }
    println(stack.first())
}

private fun parseInput() {
    val sb = StringBuilder()
    var count = 0
    loop@ while (count <= input.length - 1) {
        when {
            input[count] == ' ' -> {
                count++
                continue@loop
            }
            input[count].isDigit() || Regex("[a-zA-Z]").matches(input[count].toString()) -> {
                while (count <= input.length - 1 && (input[count].isDigit() ||
                            Regex("[a-zA-Z]").matches(input[count].toString()))) {
                    sb.append(input[count])
                    count++
                }
                expressionList.add(sb.toString())
                sb.clear()
                continue@loop
            }
            Regex("[*/()]").matches(input[count].toString()) -> {
                expressionList.add(input[count].toString())
            }
            input[count] == '+' -> {
                while (count <= input.length - 1 &&
                    input[count] == '+') {
                    sb.append(input[count])
                    count++
                }
                expressionList.add(sb.first().toString())
                sb.clear()
                continue@loop
            }
            input[count] == '-' -> {
                while (count <= input.length - 1 &&
                    input[count] == '-') {
                    sb.append(input[count])
                    count++
                }
                if (sb.length == 2) {
                    expressionList.add("+")
                } else expressionList.add("-")
                sb.clear()
                continue@loop
            }
            input[count] == '^' -> {
                expressionList.add("^")
            }
        }
        count++
    }
}

private fun getPostFixEx() {
    expressionList.forEach {
        when {
            it == "^" -> pushStack(it)
            it == "(" -> pushStack(it)
            it == ")" -> {
                if (expressionList.contains("(")) {
                    popStack()
                } else throw Exception("Error")
            }

            Regex("[\\da-zA-Z]").containsMatchIn(it) -> pushQueue(it)

            Regex("[+-]").containsMatchIn(it) ->
                if (stack.isEmpty() || stack.last() == "(") pushStack(it)
                else if (stack.last().contains(Regex("[/*^]"))) {
                    popStack()
                    pushStack(it)
                } else {
                    pushQueue(stack.last())
                    stack[stack.lastIndex] = it
                }
            Regex("[*/]").containsMatchIn(it) -> {
                if (stack.isNotEmpty() && (stack.last() == "*" || stack.last() == "/")) {
                    popStack()
                }
                pushStack(it)
            }
        }
    }
    if (stack.isNotEmpty()) {
        for (i in stack.lastIndex downTo 0) {
            if (stack[i] != "(") {
                pushQueue(stack[i])
            } else throw Exception("Error")
        }
    }
}

private fun popStack() {
    Loop@ for (i in stack.lastIndex downTo 0) {
        if (stack[i] == "(") {
            stack[i] = " "
            break@Loop
        }
        pushQueue(stack[i])
        stack[i] = " "
    }
    stack.removeIf { it == " " }
}

private fun pushQueue(item: String) {
    queue.add(item)
}

private fun pushStack(item: String) {
    stack.add(item)
}

private fun initVars() {
    val tempList = input.trim().split("=") as MutableList<String>
    if (tempList.size == 1) {
        if (variablesMap.containsKey(tempList[0])) println(variablesMap.getValue(tempList[0]))
        else println("Unknown variable")
        return
    }
    tempList.removeIf { it == "" }
    addVarsMap(tempList)
}

private fun addVarsMap(tempList: MutableList<String>) {
    if (tempList.size == 2) {
        if (Regex("\\d").containsMatchIn(tempList[0])) {
            println("Invalid identifier")
            return
        }
        try {
            if (variablesMap.containsKey(tempList[1].trim())) {
                variablesMap[tempList[0].trim()] = variablesMap.getValue(tempList[1].trim())
            } else {
                variablesMap[tempList[0].trim()] = tempList[1].trim().toInt()
            }
        } catch (e: Exception) {
            println("Invalid assignment")
            return
        }
    } else {
        println("Invalid assignment")
        return
    }
}

