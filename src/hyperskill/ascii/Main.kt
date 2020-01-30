package hyperskill.ascii


private lateinit var name: String
private lateinit var status: String
var sizeName = 0
var sizeLine = 0


fun main() {
    print("Enter name and surname:")
    name = readLine()?.toUpperCase()!!
    print("Enter person's status:")
    status = readLine()!!
    sizeName = sizeName()

    printBorderAboveAndTop()
    println()
    printName()
    println()
    printStatus()
    printBorderAboveAndTop()

}

fun printStatus() {
    val string = createMutableList()
    if (sizeLine % 2 == 0 && sizeName > status.length) {
        initAndPrintLineStatus(string, 1)
    } else {
        initAndPrintLineStatus(string, 0)
    }
}

private fun createMutableList(): MutableList<Char> {
    val string = List(sizeLine) {
        ' '
    }.toMutableList()
    string[0] = '*'
    string[string.lastIndex] = '*'
    return string
}

private fun initAndPrintLineStatus(string: MutableList<Char>, int: Int) {
    var count = 0
    for (i in (sizeLine / 2) - (status.length / 2) - int until sizeLine) {
        if (count < status.length) {
            string[i] = status[count]
            count++
        }
    }
    string.forEach {
        print(it)
    }
}

private fun printName() {
    if (sizeName > status.length) {
        printLineName()
    } else {
        repeat(3) {
            initAndPrintName(initLineName(it))
            if (it < 2) println()
        }
    }
}

private fun printLineName() {
    print("*  ")
    name.forEach {
        print(getCharFromAlphabet(it, 1))
        print(" ")
    }
    print(" *")
    println()
    print("*  ")
    name.forEach {
        print(getCharFromAlphabet(it, 2))
        print(" ")
    }
    print(" *")
    println()
    print("*  ")
    name.forEach {
        print(getCharFromAlphabet(it, 3))
        print(" ")
    }
    print(" *")
}

private fun getCharFromAlphabet(it: Char, numberLine: Int): String {
    return when (numberLine - 1) {
        0 -> Alphabet.getObject(it.toString().toUpperCase()).line1
        1 -> Alphabet.getObject(it.toString().toUpperCase()).line2
        2 -> Alphabet.getObject(it.toString().toUpperCase()).line3
        else -> ""
    }
}

fun initAndPrintName(string: String) {
    val listLine = createMutableList()
    if (sizeLine % 2 == 0) {
        var count = 0
        for (i in (sizeLine / 2) - (string.length / 2)..sizeLine) {
            if (count < string.length) {
                listLine[i] = string[count]
                count++
            }
        }
    } else {
        var count = 0
        for (i in (sizeLine / 2) - (string.length / 2) + 1 until sizeLine) {
            if (count < string.length) {
                listLine[i] = string[count]
                count++
            }
        }
    }
    listLine.forEach {
        print(it)
    }
}

private fun initLineName(int: Int): String {
    return buildString {
        name.forEach {
            when (int) {
                0 -> append(getCharFromAlphabet(it, 1))
                1 -> append(getCharFromAlphabet(it, 2))
                2 -> append(getCharFromAlphabet(it, 3))
            }
            append(" ")
        }
    }
}

fun sizeName(): Int {
    return buildString {
        append("  ")
        name.forEach {
            repeat(getCharFromAlphabet(it,1).length) {
                append("*")
            }
            if (it != name[name.length - 1]) append("*")
        }
    }.length
}

private fun printBorderAboveAndTop() {
    println()
    if (sizeName > status.length) {
        val result = StringBuilder()
        result.append("***")
        name.forEach {
            val size = ( getCharFromAlphabet(it,1)).length
            repeat(size) {
                result.append("*")
            }
            result.append("*")
        }
        result.append("**")
        print(result.toString())
        sizeLine = result.length
    } else {
        val result = StringBuilder()
        result.append("***")
        repeat(status.length) {
            result.append("*")
        }
        result.append("***")
        print(result.toString())
        sizeLine = result.length
    }
}

enum class Alphabet(val line1: String, val line2: String, val line3: String) {
    A("____", "|__|", "|  |"),
    B("___ ", "|__]", "|__]"),
    C("____", "|   ", "|___"),
    D("___ ", "|  \\", "|__/"),
    E("____", "|___", "|___"),
    F("____", "|___", "|   "),
    G("____", "| __", "|__]"),
    H("_  _", "|__|", "|  |"),
    I("_", "|", "|"),
    J(" _", " |", "_|"),
    K("_  _", "|_/ ", "| \\_"),
    L("_   ", "|   ", "|___"),
    M("_  _", "|\\/|", "|  |"),
    N("_  _", "|\\ |", "| \\|"),
    O("____", "|  |", "|__|"),
    P("___ ", "|__]", "|   "),
    Q("____", "|  |", "|_\\|"),
    R("____", "|__/", "|  \\"),
    S("____", "[__ ", "___]"),
    T("___", " | ", " | "),
    U("_  _", "|  |", "|__|"),
    V("_  _", "|  |", " \\/ "),
    W("_ _ _", "| | |", "|_|_|"),
    X("_  _", " \\/", "_/\\_"),
    Y("_   _", "  \\_/ ", "  |  "),
    Z("___ ", "  / ", " /__"),
    SPACE("    ", "    ", "    ");

    companion object {
        fun getObject(string: String): Alphabet {
            return if (string == " ") SPACE
            else valueOf(string)
        }
    }
}

