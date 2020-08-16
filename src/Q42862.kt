import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q42862()
    assertEquals(5, main.solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    assertEquals(4, main.solution(5, intArrayOf(2, 4), intArrayOf(3)))
    assertEquals(2, main.solution(3, intArrayOf(3), intArrayOf(1)))
}

class Q42862 {

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size

        var reserveIndex = 0
        run loop@{
            lost.forEach { lostNum ->
                if (reserve[reserveIndex] == (lostNum - 1) || reserve[reserveIndex] == (lostNum + 1) || reserve[reserveIndex] == lostNum) {
                    answer++
                    reserveIndex++
                }

                if (reserveIndex >= reserve.size) {
                    return@loop
                }
            }
        }

        return answer
    }

}