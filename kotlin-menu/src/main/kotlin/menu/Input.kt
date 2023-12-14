package menu
import camp.nextstep.edu.missionutils.Console.readLine

object Input {
    private fun getInput() = readLine().trim()
    fun getGuestNames(): List<String> {
        val nameList = getParsedInput()
        require(nameList.size in 2..5)
        nameList.forEach {
            require(it.length in 2..4)
        }
        return nameList
    }
    fun getInedibleMenuNames(): List<String> {
        val nameList = getParsedInput()
        require(nameList.size in 0..2)
        require(
            nameList.all {
                Menus.contains(it)
            },
        )
        return nameList
    }
    private fun getParsedInput() = getInput().split(",")
}
