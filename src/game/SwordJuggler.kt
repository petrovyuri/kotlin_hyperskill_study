package com.example.hack.game

import java.lang.IllegalStateException

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    print("")
   // juggleSwords(swordsJuggling)
    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)

    /*try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)

    } catch (e: Exception) {
        println(e)
    }*/

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling, { "Player cannot juggle swords" })
}

class UnskilledSwordJugglerException() :
    IllegalStateException("Player cannot juggle swords")

fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 2, { "Juggle at least 3 swords to be exciting." })
}