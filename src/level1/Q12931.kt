package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12931()
    assertEquals(6, main.solution(123))
    assertEquals(24, main.solution(987))
}

class Q12931 {
    fun solution(n: Int): Int {
        return n.toString().map { it.toString().toInt() }.sum()
    }
}