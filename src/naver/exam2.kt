package naver

import kotlin.math.max
import kotlin.math.sqrt
import kotlin.test.assertEquals

fun main() {
//    assertEquals(3, solution(intArrayOf(13, 7, 2, 8, 3)))
//    assertEquals(1, solution(intArrayOf(1, 2, 4, 8)))
//    assertEquals(2, solution(intArrayOf(16, 16)))
//    assertEquals(1, solution(intArrayOf(16)))
    assertEquals(1, solution(intArrayOf(1000000000)))
    assertEquals(1, solution(intArrayOf(999999999)))
}

private fun solution(A: IntArray): Int {
    var maxCount = 0
//    val binarySumArr = IntArray(sqrt(1000000000.0).toInt())
    val binarySumArr = IntArray(100)

    for (num in A) {
        val reversedBinary = Integer.toBinaryString(num).reversed().toCharArray()
        for ((index, bit) in reversedBinary.withIndex()) {
            if (bit == '1') {
                binarySumArr[index]++
            }

            maxCount = max(maxCount, binarySumArr[index])
        }
    }

    return maxCount
}