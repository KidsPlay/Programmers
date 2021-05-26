package codility.lesson05

import kotlin.test.assertEquals

private fun solution(A: IntArray): Int {
    var minValue = Double.MAX_VALUE
    var result = 0

    for (P in 0 until A.size - 1) {
        var sum: Double = A[P].toDouble()
        for (Q in P + 1 until A.size) {
            sum += A[Q]
            val avg = sum / (Q - P + 1)
            if (avg < minValue) {
                minValue = avg
                result = P
            }

//            println("P = $P / Q = $Q / sum = $sum / avg = $avg / minValue = $minValue")
        }
    }

    return result
}

fun main() {
    assertEquals(1, solution(intArrayOf(4, 2, 2, 5, 1, 5, 8)))
}