package codility.lesson01

import kotlin.math.max
import kotlin.test.assertEquals

fun solution(N: Int): Int {
    var startGap = false
    var max = 0
    var tempMax = 0
    var num = N

    while (num > 0) {
        if (num % 2 == 1) {
            startGap = true
            max = max(max, tempMax)
            tempMax = 0
        } else {
            if (startGap) {
                tempMax++
            }
        }

        num /= 2
    }

    return max
}

fun main() {
    assertEquals(2, solution(9))
    assertEquals(4, solution(529))
    assertEquals(1, solution(20))
    assertEquals(0, solution(15))
    assertEquals(0, solution(32))
    assertEquals(5, solution(1041))
    assertEquals(0, solution(32))
}
