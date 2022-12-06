fun main() {
    fun computeCalories(input: List<String>): MutableMap<Int, Int> {
        val calories = mutableMapOf<Int, Int>()
        var elfIndex = 0
        input.forEach {
            if (it.isEmpty()) {
                elfIndex++
            } else {
                var currentCalories = calories[elfIndex] ?: 0
                currentCalories += it.toInt()
                calories[elfIndex] = currentCalories
            }
        }
        return calories
    }

    fun part1(input: List<String>): Int {
        return computeCalories(input).values.max()
    }

    fun part2(input: List<String>): Int {
        return computeCalories(input).values.sorted().reversed().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/input_test.txt")
    println(part1(testInput))

    val input = readInput("day01/input")
    println(part1(input))
    println(part2(input))
}
