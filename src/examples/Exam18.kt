class Cat(var name: String? = "") {
    fun Meow() { println("Meow!") }
}
fun main(args: Array<String>) {
    var myCats = arrayOf(Cat("Misty"),
        Cat(null),
        Cat("Socks"))
    for (cat in myCats) {
        if (cat.name != null) {
            print("${cat?.name}: ")
            cat?.Meow()
        }
    }
}
