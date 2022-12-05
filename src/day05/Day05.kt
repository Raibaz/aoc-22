package day05

import readInput

typealias Stacks = List<ArrayDeque<Char>>

fun parseInput(input: List<String>): Pair<Stacks, List<Operation>> {
    val stacksInput = input.takeWhile { !it.contains("[0-9]".toRegex()) }

    val stackCount = input.first { it.contains("[0-9]".toRegex()) }.split(" ").last().toInt()

    val operations = input.dropWhile { !it.contains("move") }.map { it.toOperation() }

    val stacks = parseStacks(stacksInput, stackCount)

    return stacks to operations
}

fun parseStacks(input: List<String>, stackCount: Int) : Stacks {
    val stacks = mutableListOf<ArrayDeque<Char>>()
    (1..stackCount).forEach {
        stacks.add(ArrayDeque())
    }

    input.forEach { line ->
        var index = 0
        (1..stackCount).forEach {
            if (index > line.length) {
                return@forEach
            }
            val cell = line.substring(index, index + 3)
            if (cell.trim().isNotEmpty()) {
                stacks[it - 1].addLast(cell.removePrefix("[").removeSuffix("]")[0])
            }

            index += 4
        }
    }


    return stacks
}

data class Operation(
    val moves: Int,
    val from: Int,
    val to: Int
)

fun String.toOperation(): Operation {
    val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()
    val match = regex.find(this)
    val values = match!!.groupValues
    return Operation(values[1].toInt(), values[2].toInt(), values[3].toInt())
}

fun Stacks.processOperationsPart1(operations:  List<Operation>): Stacks {
    operations.forEach {op ->
        val from = this[op.from - 1]
        val to = this[op.to - 1]
        (0 until op.moves).forEach { _ ->
            val value = from.removeFirst()
            to.addFirst(value)
        }
        println(this)
    }

    return this
}

fun Stacks.processOperationsPart2(operations:  List<Operation>): Stacks {
    operations.forEach {op ->
        val from = this[op.from - 1]
        val to = this[op.to - 1]
        val tmp = mutableListOf<Char>()
        (0 until op.moves).forEach { _ ->
            tmp.add(from.removeFirst())
        }

        tmp.reversed().forEach {
            to.addFirst(it)
        }

        println(this)
    }

    return this
}

fun Stacks.tops(): String = this.map { it.first() }.joinToString("")


fun main() {

    fun part1(input: List<String>): String {

        val (stacks, operations) = parseInput(input)

        stacks.processOperationsPart1(operations)

        return stacks.tops()
    }

    fun part2(input: List<String>): String {
        val (stacks, operations) = parseInput(input)

        stacks.processOperationsPart2(operations)

        return stacks.tops()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day05/input_test")
    println(part1(testInput))
    println(part2(testInput))

    val input = readInput("day05/input")
    println(part1(input))
    println(part2(input))
}