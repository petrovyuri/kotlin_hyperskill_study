abstract class Animal:Roamable,TestRoam {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()

    abstract fun eat()

    override fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

class Hippo : Animal() {
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"
    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}

abstract class Canine() : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf() : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"
    override fun makeNoise() {
        println("Hooooowl!")
    }

    override fun eat() {
        println("The Wolf is eating $food")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        //Code to do something medical
        animal.makeNoise()
    }
}

fun main(args: Array<String>) {
    val animals = arrayOf(Hippo(), Wolf())
    for (item in animals) {
        item.roam()
        item.eat()
    }
    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    wolf.testRoam()

    val arrays = arrayOf(Hippo(),Wolf())
    for (item in arrays){
        item.makeNoise()
        if (item  is Animal){
            println("ANIMAL")
        }
    }

    val w1 = Wolf()
    val w2 = Wolf()
    val w3 = "1"
    val w4 = "1"
    println(w1==w2)
    println(w3==w4)

    val r1 = Recipe("Chicken Bhuna", false)
    val r2 = Recipe("Chicken Bhuna", false)

    println(r1===r2)
}

interface Roamable {
    val velocity: Int
        get() = 20

    fun roam() {
        println("The Roamable is roaming")
    }
}

class Vehicle:Roamable{
    override fun roam() {
        println("The Vehicle is roaming")
    }
}

interface TestRoam{
    fun testRoam(){
        println("Test")
    }
}

data class Recipe(val title: String, val isVegetarian: Boolean) {
    override fun toString(): String {
        return "Recipe(title='$title', isVegetarian=$isVegetarian)"
    }
}
