package codility.lesson04

import org.junit.Assert
import kotlin.math.max

private fun solution(N: Int, A: IntArray): IntArray {
    val counter = IntArray(N)

    //실제 적용 된(될) 최대값
    var maxValueAppied = 0

    //나중에 적용을 위해 계산만 해 둔 최대값
    var maxValueTemp = 0

    for (operatorNum in A) {
        val counterIndex = operatorNum - 1

        if (operatorNum in 1..N) {
            if (counter[counterIndex] <= maxValueAppied) {
                counter[counterIndex] = maxValueAppied + 1
            } else {
                counter[counterIndex]++
            }

            maxValueTemp = max(maxValueTemp, counter[counterIndex])

        } else if (operatorNum == N + 1) {
            maxValueAppied = maxValueTemp
        }
    }

    for ((i, n) in counter.withIndex()) {
        if (maxValueAppied > 0 && maxValueAppied > n) {
            counter[i] = maxValueAppied
        }
    }

    return counter
}

fun main() {
    Assert.assertArrayEquals(intArrayOf(3, 2, 2, 4, 2), solution(5, intArrayOf(3, 4, 4, 6, 1, 4, 4)))
    Assert.assertArrayEquals(intArrayOf(4, 4, 4, 4, 4), solution(5, intArrayOf(3, 4, 4, 6, 1, 4, 4, 6)))
    Assert.assertArrayEquals(intArrayOf(4, 4, 4, 4, 4), solution(5, intArrayOf(3, 4, 4, 1, 4, 4, 6)))
    Assert.assertArrayEquals(intArrayOf(1, 0, 1, 4, 0), solution(5, intArrayOf(3, 4, 4, 1, 4, 4)))
    Assert.assertArrayEquals(intArrayOf(1, 0, 1, 4, 0), solution(5, intArrayOf(6, 3, 4, 4, 1, 4, 4)))
    Assert.assertArrayEquals(intArrayOf(5, 5, 5, 5, 5), solution(5, intArrayOf(1, 1, 1, 1, 1, 6)))
    Assert.assertArrayEquals(intArrayOf(5, 3, 3, 3, 3), solution(5, intArrayOf(1, 1, 1, 6, 1, 1)))
    Assert.assertArrayEquals(intArrayOf(0, 0, 1, 0, 0), solution(5, intArrayOf(3)))
    Assert.assertArrayEquals(intArrayOf(0, 0, 0, 0, 0), solution(5, intArrayOf(6)))
    Assert.assertArrayEquals(intArrayOf(0, 0, 0, 0, 1), solution(5, intArrayOf(6, 5)))
    Assert.assertArrayEquals(intArrayOf(1), solution(1, intArrayOf(1)))
    Assert.assertArrayEquals(intArrayOf(0), solution(1, intArrayOf(3)))
}