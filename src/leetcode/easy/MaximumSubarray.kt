package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.max

fun main() {
    MatcherAssert.assertThat(maxSubArrayByKadane(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)), Matchers.`is`(6))
    MatcherAssert.assertThat(maxSubArrayByKadane(intArrayOf(1)), Matchers.`is`(1))
    MatcherAssert.assertThat(maxSubArrayByKadane(intArrayOf(5, 4, -1, 7, 8)), Matchers.`is`(23))
}

private fun maxSubArrayByKadane(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var sum = 0

    for (n in nums) {
        sum += n
        maxSum = max(maxSum, sum)
        if (sum < 0) {
            sum = 0
        }
    }

    return maxSum
}

private fun maxSubArray(nums: IntArray): Int {
    var maxSum = 0

    for (i in nums.indices) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            maxSum = max(maxSum, sum)
        }
    }

    return maxSum
}
