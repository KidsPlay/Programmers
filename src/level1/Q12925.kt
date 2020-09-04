package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12925()
    assertEquals(1234, main.solution("1234"))
    assertEquals(-1234, main.solution("-1234"))
}

class Q12925 {
    fun solution(s: String): Int {
        return s.toInt()

//        val prefix = if (s.first() == '-') -1 else 1
//        val number = if (s.first().isDigit()) s.toInt() else s.substring(1).toInt()
//
//        return number * prefix
    }
}