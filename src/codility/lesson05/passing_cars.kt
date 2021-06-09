package codility.lesson05

import kotlin.test.assertEquals

fun main() {



    assertEquals(5, solution(intArrayOf(0, 1, 0, 1, 1)))
    assertEquals(0, solution(intArrayOf(0)))
    assertEquals(0, solution(intArrayOf(1)))
    assertEquals(1, solution(intArrayOf(0, 1)))
    assertEquals(0, solution(intArrayOf(0, 0)))
    assertEquals(0, solution(intArrayOf(1, 1)))

}

private fun solution(A: IntArray): Int {
    var pCount = 0
    var result = 0

    for (n in A) {
        if (n == 0) {
            pCount++
        } else {
            result += pCount
        }

        if (result > 1000000000) {
            result = -1
            break
        }
    }

    return result
}
