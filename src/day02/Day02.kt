package day02

import readInput

fun main() {

    fun processRound1(theirPlay: Char, myPlay: Char): Int {
        return when (theirPlay) {
            'A' -> when(myPlay) {
                'X' -> 1 + 3
                'Y' -> 2 + 6
                'Z' -> 3 + 0
                else -> -1
            }
            'B' -> when(myPlay) {
                'X' -> 1 + 0
                'Y' -> 2 + 3
                'Z' -> 3 + 6
                else -> -1
            }
            'C' -> when(myPlay) {
                'X' -> 1 + 6
                'Y' -> 2 + 0
                'Z' -> 3 + 3
                else -> -1
            }
            else -> -1
        }
    }

    fun processRound2(theirPlay: Char, myPlay: Char): Int {
        return when (theirPlay) {
            'A' -> when(myPlay) {
                'X' -> 3 + 0
                'Y' -> 1 + 3
                'Z' -> 2 + 6
                else -> -1
            }
            'B' -> when(myPlay) {
                'X' -> 1 + 0
                'Y' -> 2 + 3
                'Z' -> 3 + 6
                else -> -1
            }
            'C' -> when(myPlay) {
                'X' -> 2 + 0
                'Y' -> 3 + 3
                'Z' -> 1 + 6
                else -> -1
            }
            else -> -1
        }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            processRound1(it.first(), it.last())
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            processRound2(it.first(), it.last())
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/input_test.txt")
    println(part1(testInput))

    val input = readInput("day02/input")
    println(part1(input))
    println(part2(input))
}
