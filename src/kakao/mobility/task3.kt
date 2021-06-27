package kakao.mobility

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(3, Matchers.`is`(solution(intArrayOf(3, 4, 5, 3, 7))))
    MatcherAssert.assertThat(-1, Matchers.`is`(solution(intArrayOf(1, 2, 3, 4))))
    MatcherAssert.assertThat(0, Matchers.`is`(solution(intArrayOf(1, 3, 1, 2))))
}

private fun solution(A: IntArray): Int {
    return if (isAesthetically(A)) {
        0
    } else {
        val result = A.filterIndexed { index, _ ->
            isAesthetically(A, index)
        }.count()

        if (result > 0) {
            result
        } else {
            -1
        }
    }
}

private fun isAesthetically(A: IntArray, exceptIndex: Int = -1): Boolean {
    val arr = A.toMutableList().apply {
        if (exceptIndex >= 0 && exceptIndex < A.size) {
            removeAt(exceptIndex)
        }
    }

    var reqUp = arr[0] < arr[1]

    for (i in 0 until arr.size - 1) {
        if (reqUp) {
            if (arr[i] >= arr[i + 1]) {
                return false
            }
        } else {
            if (arr[i] <= arr[i + 1]) {
                return false
            }
        }

        reqUp = !reqUp
    }

    return true
}