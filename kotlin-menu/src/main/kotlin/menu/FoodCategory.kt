package menu

import camp.nextstep.edu.missionutils.Randoms

enum class FoodCategory(val string: String) {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식"),
    ;
    fun getByIndex(index: Int): FoodCategory {
        require(index in 1..5)
        return enumValues<FoodCategory>()[index + 1]
    }
    fun pickRandom(): FoodCategory {
        val random = Randoms.pickNumberInRange(1, 5)
        return getByIndex(random)
    }
}
