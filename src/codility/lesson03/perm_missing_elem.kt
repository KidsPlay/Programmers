package codility.lesson03

import java.util.*
import kotlin.test.assertEquals

fun solution(A: IntArray): Int {
    Arrays.sort(A)

    var checkNum = 1
    for (n in A) {
        if (n != checkNum) {
            return checkNum
        } else {
            checkNum++
        }
    }

    return checkNum
}

fun main() {
    assertEquals(1, solution(intArrayOf()))
    assertEquals(4, solution(intArrayOf(2, 3, 1, 5)))
    assertEquals(1, solution(intArrayOf(2, 3, 4, 5)))
    assertEquals(5, solution(intArrayOf(2, 3, 1, 4)))
}