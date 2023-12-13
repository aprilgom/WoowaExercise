package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val NUMBER_LENGTH = 3
const val NUMBER_LENGTH_EXCEED_ERR = "number_length_exceed"
fun main() {
    TODO("프로그램 구현")
}

fun createRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getSuggestionNumber(): List<Int> {
    val input = Console.readLine()
    require(input.length > NUMBER_LENGTH) {
        NUMBER_LENGTH_EXCEED_ERR
    }
    val number = input.map {
        val num = it.digitToInt()
        require(num in 1..9)
        num
    }
    return number
}
