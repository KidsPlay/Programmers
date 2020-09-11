package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12930()
    assertEquals("TrY HeLlO WoRlD", main.solution("try hello world"))
}

class Q12930 {
    fun solution(s: String): String {
        return s.split(" ").map {
            it.toCharArray()
        }.joinToString(" ") { chars ->
            val sb = StringBuilder()

            for ((index, char) in chars.withIndex()) {
                if (index % 2 == 0) {
                    sb.append(char.toUpperCase())
                } else {
                    sb.append(char.toLowerCase())
                }
            }

            sb.toString()
        }
    }
}