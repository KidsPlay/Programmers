package leetcode.easy

import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.test.assertEquals
import kotlin.test.assertIs

fun main() {
    MatcherAssert.assertThat(containsDuplicateBySet2(intArrayOf(1, 2, 3, 1)), Matchers.`is`(true))
    MatcherAssert.assertThat(containsDuplicateBySet2(intArrayOf(1, 2, 3, 4)), Matchers.`is`(false))
    MatcherAssert.assertThat(containsDuplicateBySet2(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)), Matchers.`is`(true))

}

private fun containsDuplicateBySort(nums: IntArray): Boolean {
    nums.sort()
    for (i in 0 until nums.size - 1) {
        if (nums[i] == nums[i + 1]) return true
    }

    return false
}

private fun containsDuplicateBySet(nums: IntArray): Boolean {
    val set = HashSet<Int>()
    for (n in nums) {
        if (set.contains(n)) {
            return true
        } else {
            set.add(n)
        }
    }

    return false
}

private fun containsDuplicateBySet2(nums: IntArray): Boolean {
    return nums.toSet().size != nums.size
}