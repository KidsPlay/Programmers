package level1

import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Solution()

    assertEquals("TUE", main.solution(5, 24))
    assertEquals("FRI", main.solution(1, 8))
    assertEquals("SUN", main.solution(1, 10))
    assertEquals("MON", main.solution(2, 1))
    assertEquals("FRI", main.solution(2, 5))
    assertEquals("THU", main.solution(3, 24))
    assertEquals("FRI", main.solution(1, 1))
    assertEquals("SAT", main.solution(12, 31))
}

private class Solution {
    fun solution(a: Int, b: Int): String {
        var dayOfYear = 0

        for (month in 1 until a) {
            dayOfYear += when (month) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                2 -> 29
                4, 6, 9, 11 -> 30
                else -> throw IllegalArgumentException()
            }
        }

        dayOfYear += (b - 1)

        val days = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
        return days[dayOfYear % 7]
    }
}