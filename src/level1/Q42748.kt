package level1

import kotlin.test.assertTrue

fun main(args: Array<String>) {
    val main = Q42748()


    val answer1 = main.solution(
        intArrayOf(1, 5, 2, 6, 3, 7, 4),
        arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    )
    answer1.forEach { "${print(it)}," }
    assertTrue {
        intArrayOf(5, 6, 3).contentEquals(answer1)
    }
}

class Q42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {

        return commands.map { command ->
            val fromIndex = command[0] - 1
            val toIndex = command[1] - 1
            val findIndex = command[2] - 1

            array.slice(IntRange(fromIndex, toIndex)).sorted()[findIndex]
        }.toIntArray()
    }
}