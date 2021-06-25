package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(3, Matchers.`is`(hammingWeight(11)))
    MatcherAssert.assertThat(1, Matchers.`is`(hammingWeight(128)))
    MatcherAssert.assertThat(31, Matchers.`is`(hammingWeight(-3)))
}

private fun hammingWeight(n: Int): Int {
    return Integer.toBinaryString(n).toCharArray().count { it == '1' }
}