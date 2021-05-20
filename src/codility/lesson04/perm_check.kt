package codility.lesson04

import java.util.*
import kotlin.collections.HashSet
import kotlin.math.max
import kotlin.test.assertEquals

private fun solution(A: IntArray): Int {
    return solutionSet(A)
}

private fun solutionSet(A: IntArray): Int {
    val set = HashSet<Int>()

    var maxNum = 0
    for (num in A) {
        set.add(num)
        maxNum = max(maxNum, num)
    }

    if (maxNum != A.size || set.size != A.size) {
        return 0
    }

    var checkNum = 0
    while (set.isEmpty()) {
        checkNum++
        if (set.contains(checkNum)) {
            set.remove(checkNum)
        } else {
            return 0
        }
    }

    return 1
}

private fun solutionSort(A: IntArray): Int {
    Arrays.sort(A)

    var checkNum = 0
    for (num in A) {
        ++checkNum
        if (checkNum != num) return 0
    }

    return 1
}

fun main() {
    assertEquals(1, solution(intArrayOf(4, 1, 3, 2)))
    assertEquals(0, solution(intArrayOf(4, 3, 2)))
    assertEquals(0, solution(intArrayOf(4, 1, 3)))
    assertEquals(0, solution(intArrayOf(4)))
    assertEquals(1, solution(intArrayOf(1)))
}