package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12919()
    assertEquals("김서방은 1에 있다", main.solution(arrayOf("Jane", "Kim")))
}

class Q12919 {
    fun solution(seoul: Array<String>): String {
        return "김서방은 ${seoul.indexOfFirst { it == "Kim" }}에 있다"
    }
}