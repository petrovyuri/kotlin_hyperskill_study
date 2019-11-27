package com.example.hack

open class Room(val name: String) {
    protected open val dangerLevel = 5
    var monster: Fightable.Monster? = Fightable.Goblin()

    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel\n" +
            "Creature: ${monster?.description ?: "none."}"

    open fun load() = "Nothing much to see here..."
    public fun ringBell() = "RING BELL"
}

class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"
}
