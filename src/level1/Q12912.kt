package level1

import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12912()

    assertEquals(12, main.solution(3, 5))
    assertEquals(3, main.solution(3, 3))
    assertEquals(12, main.solution(5, 3))
}

class Q12912 {
    fun solution(a: Int, b: Int): Long {
        if (a == b) return a.toLong()

        var answer: Long = 0
        for (num in min(a, b)..max(a, b)) {
            answer += num
        }

        return answer
    }
}