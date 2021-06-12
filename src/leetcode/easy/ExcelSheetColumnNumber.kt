package leetcode.easy

import kotlin.math.pow
import kotlin.test.assertEquals

fun main() {
    assertEquals(1, titleToNumber("A"))
    assertEquals(28, titleToNumber("AB"))
    assertEquals(701, titleToNumber("ZY"))
    assertEquals(2147483647, titleToNumber("FXSHRXW"))
}

private fun titleToNumber(columnTitle: String): Int {
    var result = 0
    for ((i, ch) in columnTitle.withIndex()) {
        result += (ch - 'A' + 1) * (26.0.pow(columnTitle.length - (i + 1.0))).toInt()
    }

    return result
}