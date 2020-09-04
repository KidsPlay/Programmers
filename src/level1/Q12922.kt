package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12922()
    assertEquals("수", main.solution(1))
    assertEquals("수박", main.solution(2))
    assertEquals("수박수", main.solution(3))
    assertEquals("수박수박", main.solution(4))
}

class Q12922 {
    fun solution(n: Int): String {
        return "수박".repeat(n / 2) + if (n % 2 != 0) "수" else ""

//        val answer = StringBuilder()
//
//        for (index in 1..n / 2) {
//            answer.append("수박")
//        }
//
//        if (n % 2 > 0) {
//            answer.append("수")
//        }
//
//        return answer.toString()
    }
}