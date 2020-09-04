package level1

import java.util.*
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12917()
    assertEquals("gfedcbZ", main.solution("Zbcdefg"))
    assertEquals("cbaCBA", main.solution("aAbBcC"))
}

class Q12917 {
    fun solution(s: String): String {
        return String(s.toCharArray().sortedArrayDescending())
    }
}