package codility.demo

import java.util.Arrays
import kotlin.test.assertEquals

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun main() {
    assertEquals(5, solution(intArrayOf(1, 3, 6, 4, 1, 2)))
    assertEquals(4, solution(intArrayOf(1, 2, 3)))
    assertEquals(1, solution(intArrayOf(-1, -3)))
}

fun solution(A: IntArray): Int {
    Arrays.sort(A)

    var result = 1
    for (num in A) {
        if (num > 0 && num == result) {
            ++result
            continue
        } else if (num > result) {
            break
        }
    }

    return result
}
