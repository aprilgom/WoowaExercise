package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val NUMBER_MIN = 1
const val NUMBER_MAX = 9
const val NUMBER_LENGTH = 3
const val NUMBER_LENGTH_EXCEED_ERR = "number_length_exceed"
const val NUMBER_DUPLICATED_ERR = "number_duplicated"
const val CONTINUE_NUM = 1
const val EXIT_NUM = 2

const val START_MSG = "숫자 야구 게임을 시작합니다."
const val SUGGEST_MSG = "숫자를 입력해주세요 : "
const val BALL = "볼"
const val STRIKE = "스트라이크"
const val NOTHING = "낫싱"
const val SUCCESS_MSG = "${NUMBER_LENGTH}개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val ASK_CONTINUE_MSG = "게임을 새로 시작하려면 $CONTINUE_NUM, 종료하려면 ${EXIT_NUM}를 입력하세요."

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
) {
    override fun toString(): String {
        if (strike == 0 && ball == 0) {
            return NOTHING
        }
        if (ball == 0) {
            return "$strike$STRIKE"
        }
        if (strike == 0) {
            return "$ball$BALL"
        }
        return "$ball$BALL $strike$STRIKE"
    }
}

fun compareNumber(suggestedNumber: List<Int>, secretNumber: List<Int>): Result {
    val strike = suggestedNumber.zip(secretNumber).count { (a, b) -> a == b }
    val ball = suggestedNumber.toSet().intersect(secretNumber.toSet()).size
    return Result(strike, ball)
}
