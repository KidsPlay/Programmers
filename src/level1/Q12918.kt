package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12918()
    assertEquals(false, main.solution("a234"))
    assertEquals(true, main.solution("1234"))
}

class Q12918 {
    fun solution(s: String): Boolean {
        val length = s.filter { it.isDigit() }.length
        return (length == 4 || length == 6) && length == s.length

//        if (s.length != 4 && s.length != 6) return false
//
//        try {
//            s.toInt()
//        } catch (e: NumberFormatException) {
//            return false
//        }
//
//        return true
    }
}