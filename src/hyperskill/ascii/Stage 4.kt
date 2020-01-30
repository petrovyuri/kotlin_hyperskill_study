
import java.io.File
import java.util.*


private lateinit var name: String
private lateinit var status: String
private lateinit var mapOfName: Map<String, List<String>>
private lateinit var mapOfStatus: Map<String, List<String>>
private var sizeName = 0
private var sizeStatus = 0
private var lengthLine = 0
private var isEvenLine = false


fun main() {
    print("Enter name and surname:")
    name = readLine()!!
    print("Enter person's status:")
    status = readLine()!!
    mapOfName = createMap("C:/fonts/roman.txt", false)
    mapOfStatus = createMap("C:/fonts/medium.txt", true)
    sizeName = getSize(name, mapOfName)
    sizeStatus = getSize(status, mapOfStatus)

    if (sizeName > sizeStatus) {
        lengthLine = sizeName +8
        isEvenLine = name.length % 2 == 0
        printlnLineAboveAndTop()
        printResult(10, name, sizeName, mapOfName)
        printResult(3, status, sizeStatus, mapOfStatus)
        printlnLineAboveAndTop()
    } else {
        lengthLine =  sizeStatus +8
        isEvenLine = status.length % 2 == 0
        printlnLineAboveAndTop()
        printResult(10, name, sizeName, mapOfName)
        printResult(3, status, sizeStatus, mapOfStatus)
        printlnLineAboveAndTop()
    }
}

fun printResult(count: Int, string: String, sizeString: Int, map: Map<String, List<String>>) {
    val stringBuilder = getStringForResult(sizeString)

    if (isEvenLine){
        stringBuilder.insert((lengthLine / 2) - (sizeString / 2), string)
    } else stringBuilder.insert((lengthLine / 2) - (sizeString / 2), string)

    printLine(count, stringBuilder.toString(), map)
}

private fun printLine(count: Int, string: String, map: Map<String, List<String>>) {
    for (i in 1..count) {
        val line = java.lang.StringBuilder()
        for (j in 0..string.lastIndex)
            line.append(map[string[j].toString()]?.get(i))
        print(line)
        println()
    }
}


fun getStringForResult(size: Int): StringBuilder {
    val string = buildString {
        append("88")
        repeat(lengthLine - size - 4) {
            append("*")
        }
        append("88")
    }
    return StringBuilder(string)
}

private fun printlnLineAboveAndTop() {
    repeat(lengthLine) {
        print("8")
    }
    println()
}

private fun getSize(string: String, map: Map<String, List<String>>): Int {
    var count = 0
    string.forEach { letter ->
        count += map[letter.toString()]?.get(0)?.toInt() ?: 0
    }
    return count
}

private fun createMap(path: String, isMedium: Boolean): Map<String, List<String>> {
    val scanner = Scanner(File(path))
    val map = mutableMapOf<String, List<String>>()
    val linePropertiesFile = scanner.nextLine().trim().split(" ")
    var count = linePropertiesFile[1].toInt()
    while (count > 0) {
        val linePropertiesFonts = scanner.nextLine().trim().split(" ")
        val listFonts = mutableListOf<String>()
        listFonts.add(linePropertiesFonts[1])
        repeat(linePropertiesFile[0].toInt()) {
            listFonts.add(scanner.nextLine())
        }
        map[linePropertiesFonts[0]] = listFonts
        count--
    }

    val listSeparation = mutableListOf<String>()
    if (isMedium) {
        listSeparation.add("5")
        repeat(3) {
            listSeparation.add("     ")
        }
    } else {
        listSeparation.add("10")
        repeat(10) {
            listSeparation.add("          ")
        }
    }
    map.put(" ", listSeparation)

    val listEights = mutableListOf<String>()
    if (isMedium) {
        listEights.add("1")
        repeat(3) {
            listEights.add("8")
        }
    } else {
        listEights.add("1")
        repeat(10) {
            listEights.add("8")
        }
    }
    map.put("8", listEights)

    val listSpace = mutableListOf<String>()
    if (isMedium) {
        listSpace.add("1")
        repeat(3) {
            listSpace.add(" ")
        }
    } else {
        listSpace.add("1")
        repeat(10) {
            listSpace.add(" ")
        }
    }
    map.put("*", listSpace)
    return map
}
