package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(true, Matchers.`is`(isHappy(19)))
    MatcherAssert.assertThat(false, Matchers.`is`(isHappy(2)))
}

private fun isHappy(n: Int): Boolean {
    val set = HashSet<Int>().apply { add(n) }
    var result: Int = n

    while (result != 1) {
        var sum = 0
        result.toString().forEach {
            sum += (it - '0') * (it - '0')
        }
        result = sum

        if (set.contains(result)) {
            return false
        } else {
            set.add(result)
        }
    }

    return true
}