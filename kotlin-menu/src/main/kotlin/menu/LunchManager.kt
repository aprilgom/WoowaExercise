package menu

import menu.FoodCategory.*
class LunchManager(guests: List<Guest>) {
    val categories = setCategories()
    val menus = setMenus(guests)
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
    private fun setMenus(guests: List<Guest>): Map<Guest, List<String>> {
        val guestMenus = mutableMapOf<Guest, List<String>>()
        for (guest in guests) {
            val menus = recommendWeekMenus(guest)
            guestMenus[guest] = menus
        }
        return guestMenus
    }
    private fun recommendWeekMenus(guest: Guest): List<String> {
        val weekMenus = mutableListOf<String>()
        var day = 0
        while (true) {
            val menu = recommendMenu(categories[day], guest)
            val count = weekMenus.count { it == menu }
            if (count > 3) {
                continue
            }
            day++
        }
        return weekMenus
    }
    private fun recommendMenu(category: FoodCategory, guest: Guest): String {
        while (true) {
            val randomMenu = Menus.pickRandomMenuInCategory(category)
            if (guest.isNotEdibleMenu(randomMenu)) {
                continue
            }
            return randomMenu
        }
    }
}
