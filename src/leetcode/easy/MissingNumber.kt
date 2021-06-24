package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.max

fun main() {
    MatcherAssert.assertThat(2, Matchers.`is`(missingNumber(intArrayOf(3, 0, 1))))
    MatcherAssert.assertThat(2, Matchers.`is`(missingNumber(intArrayOf(0, 1))))
    MatcherAssert.assertThat(8, Matchers.`is`(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1))))
    MatcherAssert.assertThat(1, Matchers.`is`(missingNumber(intArrayOf(0))))
    MatcherAssert.assertThat(0, Matchers.`is`(missingNumber(intArrayOf(1))))
}

private fun missingNumber(nums: IntArray): Int {
    val expectedSum = nums.size * (nums.size + 1) / 2
    val actualSum = nums.sum()
    return expectedSum - actualSum

//    var sum = 0
//    var maxNum = 0
//    var existZero = false
//    for (n in nums) {
//        sum += n
//        maxNum = max(maxNum, n)
//
//        if (!existZero && n == 0) {
//            existZero = true
//        }
//    }
//
//    val sumOfMaxNum = (1..maxNum).sum()
//
//    var result = sumOfMaxNum - sum
//    if (result == 0) {
//        result = if (existZero) {
//            maxNum + 1
//        } else {
//            0
//        }
//    }
//
//    return result
}