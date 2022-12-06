package day04

import readInput

fun main() {

    fun String.parseLine() : Pair<IntRange, IntRange> {
        val pairs = this.split(",")
        val first = pairs[0].split("-")
        val second = pairs[1].split("-")

        return first[0].toInt() ..first[1].toInt() to second[0].toInt() .. second[1].toInt()
    }

    fun Pair<IntRange, IntRange>.fullyContains(): Boolean =
        (this.first.contains(this.second.first) && this.first.contains(this.second.last)) ||
            (this.second.contains(this.first.first) && this.second.contains(this.first.last))

    fun Pair<IntRange, IntRange>.partiallyContains(): Boolean =
        this.first.contains(this.second.first) || this.first.contains(this.second.last) ||
        this.second.contains(this.first.first) || this.second.contains(this.first.last)

    fun part1(input: List<String>): Int = input.map { it.parseLine() }.count { it.fullyContains() }

    fun part2(input: List<String>): Int = input.map { it.parseLine() }.count { it.partiallyContains() }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/input_test.txt")
    println(part1(testInput))

    val input = readInput("day04/input")
    println(part1(input))
    println(part2(input))
}