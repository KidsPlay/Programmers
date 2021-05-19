package codility.lesson03

import kotlin.math.abs
import kotlin.math.min
import kotlin.test.assertEquals

private fun solution(A: IntArray): Int {
    var frontSum = A[0]
    var backSum = A.sum() - frontSum
    var minDifference = abs(frontSum - backSum)

    for (i in 1..A.size - 2) {
        frontSum += A[i]
        backSum -= A[i]
        minDifference = min(minDifference, abs(frontSum - backSum))
    }

    return minDifference
}

fun main() {
    assertEquals(1, solution(intArrayOf(3, 1, 2, 4, 3)))
    assertEquals(2, solution(intArrayOf(3, 1)))
    assertEquals(4, solution(intArrayOf(3, -1)))
}
