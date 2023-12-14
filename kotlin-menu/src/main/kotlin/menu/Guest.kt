package menu

class Guest(val name: String, private val inedibleMenus: List<String>) {
    fun isNotEdibleMenu(menu: String) = menu !in inedibleMenus
}
