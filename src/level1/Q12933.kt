package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12933()
    assertEquals(873211, main.solution(118372))
}

class Q12933 {
    fun solution(n: Long): Long {
        return n.toString().toCharArray().sortedArrayDescending().joinToString("").toLong()
    }
}