package com.example.dicerollingapp
import kotlin.random.Random

class dice(private val sides: Int) {

    fun roll(): Int {
        return Random.nextInt(1, sides + 1)
    }
}





