import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q42862()
    assertEquals(5, main.solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    assertEquals(5, main.solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 4, 5)))
    assertEquals(4, main.solution(5, intArrayOf(2, 3), intArrayOf(5, 4, 3)))
    assertEquals(4, main.solution(5, intArrayOf(2, 4), intArrayOf(3)))
    assertEquals(2, main.solution(3, intArrayOf(3), intArrayOf(1)))
    assertEquals(2, main.solution(2, intArrayOf(3), intArrayOf(3)))
}

class Q42862 {

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

        var answer = n
        val lostSet = lost.toSet() - reserve.toSet()
        val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

        for (i in lostSet) {
            when {
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                else -> answer--
            }
        }

        return answer

    }
}