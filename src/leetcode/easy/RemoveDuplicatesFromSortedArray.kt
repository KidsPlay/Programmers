package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    var arr = intArrayOf(1, 1, 2)
    MatcherAssert.assertThat(removeDuplicates(arr), Matchers.`is`(2))
    MatcherAssert.assertThat(checkContents(arr, intArrayOf(1, 2), 2), Matchers.`is`(true))

    arr = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    MatcherAssert.assertThat(removeDuplicates(arr), Matchers.`is`(5))
    MatcherAssert.assertThat(checkContents(arr, intArrayOf(0, 1, 2, 3, 4), 5), Matchers.`is`(true))
}

private fun removeDuplicates(nums: IntArray): Int {
    var replaceIndex = 0
    var checkNum = Int.MAX_VALUE

    for (n in nums) {
        if (n != checkNum) {
            checkNum = n
            nums[replaceIndex++] = n
        }
    }

    return replaceIndex
}

fun checkContents(result: IntArray, expected: IntArray, length: Int): Boolean {
    for (i in 0 until length) {
        if (result[i] != expected[i]) {
            return false
        }
    }

    return true
}
