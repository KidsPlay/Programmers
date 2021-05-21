package codility.lesson05

import org.junit.Assert
import kotlin.math.min

private fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
    return solutionArr(S, P, Q)
}

private fun solutionArr(S: String, P: IntArray, Q: IntArray): IntArray {
    val A = IntArray(S.length + 1)
    val C = IntArray(S.length + 1)
    val G = IntArray(S.length + 1)

    for ((i, ch) in S.withIndex()) {
        A[i + 1] = A[i]
        C[i + 1] = C[i]
        G[i + 1] = G[i]

        when (ch) {
            'A' -> A[i + 1]++
            'C' -> C[i + 1]++
            'G' -> G[i + 1]++
        }
    }

    val resultArr = IntArray(P.size)
    for (i in P.indices) {
        val startIndex = P[i]
        val endIndex = Q[i] + 1
        resultArr[i] = when {
            A[endIndex] - A[startIndex] != 0 -> 1
            C[endIndex] - C[startIndex] != 0 -> 2
            G[endIndex] - G[startIndex] != 0 -> 3
            else -> 4
        }
    }

    return resultArr
}

private fun solutionHonest(S: String, P: IntArray, Q: IntArray): IntArray {
    val arrS = IntArray(S.length)
    for ((i, ch) in S.withIndex()) {
        arrS[i] = when (ch) {
            'A' -> 1
            'C' -> 2
            'G' -> 3
            else -> 4
        }
    }

    val resultArr = IntArray(P.size)
    for (i in P.indices) {
        var minNum = Int.MAX_VALUE
        for (j in P[i]..Q[i]) {
            minNum = min(minNum, arrS[j])
        }
        resultArr[i] = minNum
    }

    return resultArr
}

fun main() {
    Assert.assertArrayEquals(intArrayOf(2, 4, 1), solution("CAGCCTA", intArrayOf(2, 5, 0), intArrayOf(4, 5, 6)))
    Assert.assertArrayEquals(intArrayOf(2), solution("C", intArrayOf(0), intArrayOf(0)))
    Assert.assertArrayEquals(intArrayOf(1), solution("A", intArrayOf(0), intArrayOf(0)))
    Assert.assertArrayEquals(intArrayOf(1, 1, 1), solution("A", intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)))
    Assert.assertArrayEquals(intArrayOf(2, 1, 1), solution("CA", intArrayOf(0, 0, 1), intArrayOf(0, 1, 1)))
}