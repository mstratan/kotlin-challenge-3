package academy.learnprogramming.oochallenge.round2

fun main() {
    val bike2 = Bicycle(5, 10)
    bike2.printDescription()

    val mountainBike2 = MountainBike(22, 6, 11)
    mountainBike2.printDescription()

    val roadBike2 = RoadBike(55, 4, 20)
    roadBike2.printDescription()

    val mountainBike3 = MountainBike(100, 100, 100, 100, "Red")
    mountainBike3.printDescription()

    MountainBike.availableColors.listIterator().forEach{ i -> println(i)}
}


open class Bicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription(){
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed.")
    }
}

class MountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10): Bicycle(cadence, speed, gear) {

    constructor(seatHeight: Int, cadence: Int, speed: Int, gear: Int, color: String):
            this(seatHeight, cadence, speed, gear) {

                println("The color is $color")
    }

    companion object {
        val availableColors = listOf("blue", "red", "white", "black", "green", "brown")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }
}

class RoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10): Bicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth MM.")
    }
}