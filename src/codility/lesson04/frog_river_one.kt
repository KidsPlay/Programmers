package codility.lesson04

import kotlin.test.assertEquals

private fun solution(X: Int, A: IntArray): Int {
    var count = X
    val arr = BooleanArray(X + 1) { true }

    for ((index, n) in A.withIndex()) {
        if (arr[n]) {
            arr[n] = false
            count--

            if (count == 0) {
                return index
            }
        }
    }

    return -1
}

fun main() {
    assertEquals(6, solution(5, intArrayOf(1, 3, 1, 4, 2, 3, 5, 4)))
    assertEquals(-1, solution(6, intArrayOf(1, 3, 1, 4, 2, 3, 5, 4)))
    assertEquals(0, solution(1, intArrayOf(1)))
    assertEquals(1, solution(2, intArrayOf(1, 2)))
}