package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val NUMBER_MIN = 1
const val NUMBER_MAX = 9
const val NUMBER_LENGTH = 3
const val NUMBER_LENGTH_EXCEED_ERR = "number_length_exceed"
const val NUMBER_DUPLICATED_ERR = "number_duplicated"
fun main() {
    TODO("프로그램 구현")
}

fun createRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < NUMBER_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getSuggestionNumber(): List<Int> {
    val input = Console.readLine()
    require(input.length == NUMBER_LENGTH) {
        NUMBER_LENGTH_EXCEED_ERR
    }
    val number = input.map {
        val num = it.digitToInt()
        require(num in NUMBER_MIN..NUMBER_MAX)
        num
    }
    require(number.toSet().size == NUMBER_LENGTH) {
        NUMBER_DUPLICATED_ERR
    }
    return number
}
data class Result(
    val strike: Int,
    val ball: Int,
)

fun compareNumber(suggestedNumber: List<Int>, secretNumber: List<Int>): Result {
    val strike = suggestedNumber.zip(secretNumber).count { (a, b) -> a == b }
    val ball = suggestedNumber.toSet().intersect(secretNumber.toSet()).size
    return Result(strike, ball)
}
