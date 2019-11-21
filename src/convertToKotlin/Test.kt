package convertToKotlin

import java.util.*

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val count = 10
        val stringBuilder = StringBuilder()
        for (i in 0 until count) {
            stringBuilder.append(".")
        }
        println(stringBuilder)


        val hashSet = HashSet<String>()
        hashSet.add("Yura")
        hashSet.add("Oleg")
        hashSet.add("Vadim")

        val it = hashSet.iterator()
        while (it.hasNext()) {
            println(it.next())
        }

    }
}
