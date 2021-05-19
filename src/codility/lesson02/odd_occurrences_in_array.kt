package codility.lesson02

import java.util.*
import kotlin.test.assertEquals

fun solution(A: IntArray): Int {
    return solutionBit(A)
}

private fun solutionBit(A: IntArray): Int {
    var result = 0
    for (n in A) {
        result = n xor result
    }

    return result
}

private fun solutionSort(A: IntArray): Int {
    Arrays.sort(A)

    var count = 0
    var num = A[0]

    for (n in A) {
        if (num == n) {
            count++
        } else {
            if (count % 2 != 0) {
                return num
            } else {
                num = n
                count = 1
            }
        }
    }

    return num
}

private fun solutionSet(A: IntArray): Int {
    val set = mutableSetOf<Int>()

    for (n in A) {
        if (set.contains(n)) {
            set.remove(n)
        } else {
            set.add(n)
        }
    }

    return set.first()
}

fun main() {
    assertEquals(7, solution(intArrayOf(9, 3, 9, 3, 9, 7, 9)))
    assertEquals(3, solution(intArrayOf(9, 3, 9, 7, 9, 7, 9)))
    assertEquals(9, solution(intArrayOf(9, 3, 3, 7, 9, 7, 9)))
    assertEquals(3, solution(intArrayOf(3)))
}
