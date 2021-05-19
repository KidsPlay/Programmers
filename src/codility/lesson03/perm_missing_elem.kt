package codility.lesson03

import java.util.*
import kotlin.test.assertEquals

fun solution(A: IntArray): Int {
    return solutionArray(A)
}

private fun solutionArray(A: IntArray): Int {
    val arr = IntArray(100002)

    for (n in A) {
        arr[n]++
    }

    for (n in 1..A.size + 1) {
        if (arr[n] == 0) {
            return n
        }
    }

    return -1
}

private fun solutionSort(A: IntArray): Int {
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