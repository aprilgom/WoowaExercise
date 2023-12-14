package menu

import menu.FoodCategory.*
class LunchManager(private val guests: List<Guest>) {
    val categories = setCategories()
    init {
        require(guests.size in 2..5)
    }
    private fun setCategories(): List<FoodCategory> {
        val categories = mutableListOf<FoodCategory>()
        categories.add(FoodCategory.pickRandom())
        while (categories.size < 5) {
            val newCategory = FoodCategory.pickRandom()
            val count = categories.count { it == newCategory }
            if (count >= 2) {
                continue
            }
            categories.add(newCategory)
        }
        return categories
    }
}
