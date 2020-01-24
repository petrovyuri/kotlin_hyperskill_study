package hyperskill.solveDay

// write your code here

/* Do not change code below */
fun main(args: Array<String>) {
    var size = 2
    var capacity = 4
    var element = 0
    while (capacity < 1023) {
        size++
        element++
        if (size == capacity + 1) {
            capacity *= 2
        }
    }

    println(element)
}

