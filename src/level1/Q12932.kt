package level1

import kotlin.test.assertTrue

fun main(args: Array<String>) {
    val main = Q12932()
    assertTrue {
        intArrayOf(1).contentEquals(main.solution(1))
        intArrayOf(2, 1).contentEquals(main.solution(12))
        intArrayOf(3, 2, 1).contentEquals(main.solution(123))
        intArrayOf(4, 3, 2, 1).contentEquals(main.solution(1234))
        intArrayOf(5, 4, 3, 2, 1).contentEquals(main.solution(12345))
    }
}

class Q12932 {
    fun solution(n: Long): IntArray {
        return n.toString()
            .reversed()
            .map { it.toString().toInt() }
            .toIntArray()
    }
}