package codility.lesson05

import kotlin.test.assertEquals

private fun solution(A: Int, B: Int, K: Int): Int {
    return solutionCalc(A, B, K)
}

private fun solutionCalc(A: Int, B: Int, K: Int): Int {
    var count = (B / K) - (A / K)

    if (A % K == 0) {
        count++
    }

    return count
}

private fun solutionBasic(A: Int, B: Int, K: Int): Int {
    var result = 0
    for (num in A..B) {
        if (num % K == 0) {
            result++
        }
    }

    return result
}

fun main() {
    assertEquals(1, solution(0, 1, 11))
    assertEquals(2, solution(0, 1, 1))
    assertEquals(2, solution(1, 2, 1))
    assertEquals(1, solution(1, 2, 2))
    assertEquals(0, solution(1, 2, 3))

    assertEquals(3, solution(6, 11, 2))
    assertEquals(2, solution(6, 11, 3))
    assertEquals(1, solution(6, 11, 4))
    assertEquals(1, solution(6, 11, 5))
    assertEquals(1, solution(6, 11, 6))

    assertEquals(9, solution(12, 29, 2))
    assertEquals(6, solution(12, 29, 3))
    assertEquals(5, solution(12, 29, 4))
    assertEquals(3, solution(12, 29, 5))
    assertEquals(3, solution(12, 29, 6))
    assertEquals(3, solution(12, 29, 7))
    assertEquals(2, solution(12, 29, 8))
    assertEquals(2, solution(12, 29, 9))
    assertEquals(1, solution(12, 29, 10))

}