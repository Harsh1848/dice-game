import kotlin.random.Random

class dice (private val sides: Int) {

    fun roll(): Int {
        return random.nextInt(1, sides + 1)
    }
}
