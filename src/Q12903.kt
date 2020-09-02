import kotlin.test.assertEquals

fun main(args: Array<String>) {

    val main = Q12903()

    assertEquals("a", main.solution("a"))
    assertEquals("b", main.solution("abc"))
    assertEquals("c", main.solution("abcde"))
    assertEquals("qw", main.solution("qw"))
    assertEquals("we", main.solution("qwer"))
    assertEquals("er", main.solution("qwerab"))
}

class Q12903 {
    fun solution(s: String): String {
//        val strLength = s.length
//        val startIndex = if (strLength % 2 == 0) strLength / 2 - 1 else strLength / 2
//        val endIndex = if (strLength % 2 == 0) strLength / 2 + 1 else strLength / 2 + 1
//
//        return s.substring(startIndex, endIndex)

        return s.slice((s.length - 1) / 2..s.length / 2)
    }
}