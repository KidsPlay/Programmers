package level1

import kotlin.test.assertTrue

fun main(args: Array<String>) {
    val main = Q12910()

    assertTrue { intArrayOf(5, 10).contentEquals(main.solution(intArrayOf(5, 9, 7, 10), 5)) }
    assertTrue { intArrayOf(1, 2, 3, 36).contentEquals(main.solution(intArrayOf(2, 36, 1, 3), 1)) }
    assertTrue { intArrayOf(-1).contentEquals(main.solution(intArrayOf(3, 2, 6), 10)) }
}

class Q12910 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        arr.filter { it % divisor == 0 }.toIntArray().let {
            return if (it.isNotEmpty()) {
                it.sortedArray()
            } else {
                intArrayOf(-1)
            }
        }
    }
}