package woowa

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.abs
import kotlin.math.max

fun main() {
    MatcherAssert.assertThat(solution(intArrayOf(3, 2, -2, 5, -3)), Matchers.`is`(3))
    MatcherAssert.assertThat(solution(intArrayOf(1, 1, 2, -1, 2, -1)), Matchers.`is`(1))
    MatcherAssert.assertThat(solution(intArrayOf(1, 2, 3, -4)), Matchers.`is`(0))
    MatcherAssert.assertThat(solution(intArrayOf(-4)), Matchers.`is`(0))
}
//정렬 후 start, end position으로도 가능할 듯.
private fun solution(A: IntArray): Int {
    var maxValue = 0
    val set = HashSet<Int>()

    for (n in A) {
        set.add(n)

        if (set.contains(n * -1)) {
            maxValue = max(maxValue, abs(n))
        }
    }

    return maxValue
}