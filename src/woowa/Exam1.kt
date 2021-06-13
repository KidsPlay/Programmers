package woowa

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import java.lang.StringBuilder

fun main() {
    MatcherAssert.assertThat(solution(3, 2, intArrayOf(2, 1, 1, 0, 1)), Matchers.`is`("11001,10100"))
    MatcherAssert.assertThat(solution(2, 3, intArrayOf(0, 0, 1, 1, 2)), Matchers.`is`("IMPOSSIBLE"))
    MatcherAssert.assertThat(solution(2, 2, intArrayOf(2, 0, 2, 0)), Matchers.`is`("1010,1010"))
}

private fun solution(U: Int, L: Int, C: IntArray): String {
    var cntU = U
    var cntL = L
    val arrU = IntArray(C.size)
    val arrL = IntArray(C.size)

    for ((i, n) in C.withIndex()) {
        if (n == 2) {
            arrU[i] = 1
            arrL[i] = 1
            cntU--
            cntL--
        } else if (n == 1) {
            if (cntU > cntL) {
                arrU[i] = 1
                cntU--
            } else {
                arrL[i] = 1
                cntL--
            }
        }

        if (cntU < 0 || cntL < 0) {
            return "IMPOSSIBLE"
        }
    }

    return if (cntU != 0 || cntL != 0) {
        "IMPOSSIBLE"
    } else {
        return StringBuilder().apply {
            for (n in arrU) {
                append(n)
            }
            append(",")
            for (n in arrL) {
                append(n)
            }
        }.toString()
    }
}