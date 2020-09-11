package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12926()
    assertEquals("BC", main.solution("AB", 1))
    assertEquals("A", main.solution("Z", 1))
    assertEquals("a", main.solution("z", 1))
    assertEquals("b", main.solution("a", 1))
    assertEquals("z", main.solution("a", 25))
    assertEquals("e F d", main.solution("a B z", 4))
}

class Q12926 {
    fun solution(s: String, n: Int): String {
        return s.toCharArray().map {
            if (it == ' ') {
                it
            } else {
                val ch = it + n
                if ((it.isUpperCase() && ch > 'Z') || (it.isLowerCase() && ch > 'z')) {
                    ch - 26
                } else {
                    ch
                }
            }
        }.joinToString("")
    }
}