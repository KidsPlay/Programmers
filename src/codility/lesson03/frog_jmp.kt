package codility.lesson03

import kotlin.test.assertEquals

fun solution(X: Int, Y: Int, D: Int): Int {
    var result = (Y - X) / D
    if ((Y - X) % D != 0) {
        result++
    }

    return result
}

fun main() {
    assertEquals(3, solution(10, 85, 30))
    assertEquals(1, solution(10, 40, 30))
    assertEquals(0, solution(10, 10, 30))
}
