package naver

import kotlin.test.assertEquals

fun main() {
    Integer.toBinaryString(100)
    var sum = 0
    for (i in 1..100000) {

    }
    println(sum)

    assertEquals(4, solution(intArrayOf(2, -2, 3, 0, 4, -7)))
    assertEquals(-1, solution(IntArray(100000) { 0 }))
}

private fun solution(A: IntArray): Int {
    var result = 0

    var sum = 0
    val sumArr = IntArray(A.size)
    for ((i, n) in A.withIndex()) {
        sum += n
        sumArr[i] = sum

        if (sum == 0) {
            result++
        }
    }

    for (i in 0 until A.size - 1) {
        for (j in i + 1 until A.size) {
            if (sumArr[j] - sumArr[i] == 0) {
                result++
            }
        }
    }

    return result
}