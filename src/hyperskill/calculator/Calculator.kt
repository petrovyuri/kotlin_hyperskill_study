package calculator

import java.util.*
import kotlin.math.pow

var variablesMap = mutableMapOf<String, Int>()
lateinit var input: String
var inputsList = mutableListOf<String>()
var stack = mutableListOf<String>()
var queuePosFix = mutableListOf<String>()
var queueInFix = mutableListOf<String>()
var expressionList = mutableListOf<String>()

fun main() {
    val scanner = Scanner(System.`in`)
    var exit = false

    loop@ while (!exit) {

        input = scanner.nextLine()
        inputsList = input.split(" ") as MutableList<String>
        stack.clear()
        queuePosFix.clear()
        expressionList.clear()
        queueInFix.clear()

        if (inputsList[0].isEmpty() || input.first() == '/') {
            when (inputsList[0]) {
                "" -> continue@loop
                "/" -> variablesMap.forEach { s, i ->
                    println("$s $i")
                }
                "/exit" -> {
                    println("Bye!")
                    exit = true
                }
                "/help" -> println("The program calculates the sum of numbers")
                else -> println("Unknown command")
            }
        } else if (Regex("[^\\w ^=]").containsMatchIn(input)) {
            try {
                getParseInput()
                getPostFixEx()
                calcPostFixEx()
            } catch (e: Exception) {
                println("Invalid expression")
            }
        } else {
            var tempList = input.trim().split("=") as MutableList<String>
            if (tempList.size == 1) {
                if (variablesMap.containsKey(tempList[0])) println(variablesMap.getValue(tempList[0]))
                else println("Unknown variable")
                continue@loop
            }
            tempList.removeIf { it == "" }
            addMap(tempList)
        }
    }
}

fun calcPostFixEx() {
    var tempResult = 0
    stack.clear()
    for (i in 0 until queuePosFix.size) {
        when {
            Regex("[\\da-zA-Z]").containsMatchIn(queuePosFix[i]) -> {
                if (variablesMap.containsKey(queuePosFix[i])){
                    stack.add(variablesMap.getValue(queuePosFix[i]).toString())
                } else stack.add(queuePosFix[i])
            }
            queuePosFix[i] == "+" -> {
                tempResult = stack[stack.lastIndex].toInt() + stack[stack.lastIndex - 1].toInt()
                stack[stack.lastIndex] = " "
                stack[stack.lastIndex - 1] = tempResult.toString()
                stack.remove(" ")
            }
            queuePosFix[i] == "*" -> {
                tempResult = stack[stack.lastIndex].toInt() * stack[stack.lastIndex - 1].toInt()
                stack[stack.lastIndex] = " "
                stack[stack.lastIndex - 1] = tempResult.toString()
                stack.remove(" ")
            }
            queuePosFix[i] == "/" -> {
                tempResult = stack[stack.lastIndex - 1].toInt() / stack[stack.lastIndex].toInt()
                stack[stack.lastIndex] = " "
                stack[stack.lastIndex - 1] = tempResult.toString()
                stack.remove(" ")
            }
            queuePosFix[i] == "-" -> {
                tempResult = stack[stack.lastIndex - 1].toInt() - stack[stack.lastIndex].toInt()
                stack[stack.lastIndex] = " "
                stack[stack.lastIndex - 1] = tempResult.toString()
                stack.remove(" ")
            }
            queuePosFix[i] == "^" -> {
                tempResult = stack[stack.lastIndex - 1].toDouble().pow(stack[stack.lastIndex].toDouble()).toInt()
                stack[stack.lastIndex] = " "
                stack[stack.lastIndex - 1] = tempResult.toString()
                stack.remove(" ")
            }
        }
    }
    println(stack.first())
}

fun getParseInput() {
    var sb = StringBuilder()
    var count = 0
    loop@ while (count <= input.length - 1) {
        when {
            input[count] == ' ' -> {
                count++
                continue@loop
            }
            input[count].isDigit() || Regex("[a-zA-Z]").containsMatchIn(input[count].toString()) -> {
                while (count <= input.length - 1 && (input[count].isDigit() ||
                            Regex("[a-zA-Z]").containsMatchIn(input[count].toString()))) {
                    sb.append(input[count])
                    count++
                }
                expressionList . add (sb.toString())
                sb . clear ()
                continue@loop
            }
            Regex("[*/()]").containsMatchIn(input[count].toString()) -> {
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

fun getPostFixEx() {
    for (i in expressionList.indices) {
        if (i < expressionList.size - 1) {
            when {
                expressionList[i] == "^" -> {
                    stack.add(expressionList[i])
                }
                expressionList[i] == ")" -> {
                    Loop@ for (h in stack.lastIndex downTo 0) {
                        if (stack[h] == "(") {
                            stack[h] = " "
                            break@Loop
                        }
                        queuePosFix.add(stack[h])
                        stack[h] = " "
                    }
                    stack.removeIf { it == " " }
                }

                expressionList[i] == "(" -> stack.add(expressionList[i])

                Regex("[\\da-zA-Z]").containsMatchIn(expressionList[i]) -> {
                    queuePosFix.add(expressionList[i])
                }
                Regex("[+-]").containsMatchIn(expressionList[i]) ->
                    if (stack.isEmpty() || stack[stack.lastIndex] == "(") {
                        stack.add(expressionList[i])
                    } else if (stack[stack.lastIndex] == "/"
                        || stack[stack.lastIndex] == "*"
                        || stack[stack.lastIndex] == "^") {
                        Loop@ for (j in stack.lastIndex downTo 0) {
                            if (stack[j] == "(") break@Loop
                            queuePosFix.add(stack[j])
                            stack[j] = " "
                        }
                        stack.removeIf { it == " " }
                        stack.add(expressionList[i])
                    } else {
                        queuePosFix.add(stack[stack.lastIndex])
                        stack[stack.lastIndex] = expressionList[i]
                    }
                Regex("[*/]").containsMatchIn(expressionList[i]) -> {
                    if (stack.isNotEmpty()
                        && (stack[stack.lastIndex] == "*"
                                || stack[stack.lastIndex] == "/")) {
                        Loop@ for (z in stack.lastIndex downTo 0) {
                            if (stack[z] == "(") break@Loop
                            if (stack[z] == "+") break@Loop
                            if (stack[z] == "-") break@Loop
                            queuePosFix.add(stack[z])
                            stack[z] = " "
                        }
                        stack.remove(" ")
                    }
                    stack.add(expressionList[i])
                }
            }
        } else {
            if (Regex("[\\da-zA-Z]").containsMatchIn(expressionList[i])) {
                queuePosFix.add(expressionList[i])
                for (j in stack.lastIndex downTo 0) {
                    if (stack[j] != "(") {
                        queuePosFix.add(stack[j])
                    } else throw Exception("Error")
                }
            } else if (expressionList[i] == ")") {
                if (!stack.contains("(")) throw Exception("Error")
                for (h in stack.lastIndex downTo 0) {
                    if (stack[h] != "(") {
                        queuePosFix.add(stack[h])
                    }
                }
            } else throw Exception("Error")
        }
    }
}

fun addMap(tempList: MutableList<String>) {
    if (tempList.size > 2) {
        println("Invalid assignment")
        return
    }
    if (Regex("\\d").containsMatchIn(tempList[0])) {
        println("Invalid identifier")
        return
    }
    try {
        if (variablesMap.containsKey(tempList[1].trim())) {
            variablesMap.put(tempList[0].trim(), variablesMap.getValue(tempList[1].trim()))
        } else {
            variablesMap.put(tempList[0].trim(), tempList[1].trim().toInt())
        }
    } catch (e: Exception) {
        println("Invalid assignment")
        return
    }
}


