package codility.lesson04

import java.util.*
import kotlin.collections.HashSet
import kotlin.test.assertEquals

private fun solution(A: IntArray): Int {
    return solutionSet(A)
}

private fun solutionSet(A: IntArray): Int {
    val set = HashSet<Int>()
    A.filter { it > 0 }.map { set.add(it) }

    for (checkNum in 1..Int.MAX_VALUE){
        if(!set.contains(checkNum)){
            return checkNum
        }
    }

    return -1
}

private fun solutionSort(A: IntArray): Int {
    Arrays.sort(A)

    var checkNum = 1
    for (n in A) {
        if (n == checkNum) {
            ++checkNum
        } else if (n > checkNum) {
            break
        }
    }

    return checkNum
}

fun main() {
    assertEquals(5, solution(intArrayOf(1, 3, 6, 4, 1, 2)))
    assertEquals(4, solution(intArrayOf(1, 2, 3)))
    assertEquals(1, solution(intArrayOf(2, 3, 4)))
    assertEquals(2, solution(intArrayOf(1)))
    assertEquals(1, solution(intArrayOf(2)))
    assertEquals(1, solution(intArrayOf(-2)))
    assertEquals(1, solution(intArrayOf(-1, -3)))
    assertEquals(2, solution(intArrayOf(-1, -3, 1)))
}