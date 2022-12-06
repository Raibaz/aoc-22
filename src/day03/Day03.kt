package day03

import readInput

fun main() {

    fun Char.convertValue() : Int {
        val ret = if (this.isLowerCase()) {
            this.code - 'a'.code + 1
        } else {
            this.code - 'A'.code + 27
        }

        return ret
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            line.take(line.length / 2).find {
                line.takeLast(line.length / 2).contains(it)
            }!!.convertValue()
        }
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3, 3).sumOf { group ->
            group[0].find {
                group[1].contains(it) && group[2].contains(it)
            }!!.convertValue()

        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/input_test")
    println(part1(testInput))

    val input = readInput("day03/input")
    println(part1(input))
    println(part2(input))
}