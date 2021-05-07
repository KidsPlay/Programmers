package interview.coupang.d_20210206

import org.junit.Assert

fun main() {
    val main = Exam3()

    Assert.assertEquals(true, main.solution(intArrayOf(5, 3, 9, 13), 8))
    Assert.assertEquals(false, main.solution(intArrayOf(5, 3, 9, 13), 7))
}

class Exam3 {
    fun solution(arr: IntArray, n: Int): Boolean {
        var answer = false

        arr.sort()

        loop@ for (i in 0..arr.size - 2) {
            for (j in i + 1 until arr.size) {
                val sum = arr[i] + arr[j]

                if (sum == n) {
                    answer = true
                    break@loop
                } else if (sum > n) {
                    break
                }
            }
        }

        return answer
    }
}