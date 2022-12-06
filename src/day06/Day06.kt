package day06

import readInput

fun String.findMarker(markerSize: Int): Int {
    this.windowed(markerSize, 1).forEachIndexed { index, window ->
        val occurrences = window.fold(mutableMapOf<Char, Int>()) { acc, c ->
            val cur = acc.getOrDefault(c, 0)
            acc[c] = cur + 1
            acc
        }

        if (occurrences.keys.size ==  markerSize) {
            return index + markerSize
        }
    }

    return -1
}

fun main() {

    fun part1(input: String) = input.findMarker(4)
    fun part2(input: String) = input.findMarker(14)

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06/input_test")
    println(part1(testInput[0]))
    println(part2(testInput[0]))

    val input = readInput("day06/input")
    println(part1(input[0]))
    println(part2(input[0]))
}