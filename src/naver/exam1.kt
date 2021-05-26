package naver

import java.lang.StringBuilder
import kotlin.test.assertEquals

fun main() {
    assertEquals("SSSML", solution("MSSLS"))
    assertEquals("SMLL", solution("LLMS"))
    assertEquals("SSM", solution("SMS"))
    assertEquals("S", solution("S"))
}

private fun solution(T: String): String {
    val arr = T.toCharArray()
    arr.sortDescending()
    val sb = StringBuilder()
    for (ch in arr) {
        sb.append(ch)
    }

    return sb.toString()
}