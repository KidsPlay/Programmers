package leetcode.easy

import java.lang.IllegalStateException
import kotlin.test.assertEquals

fun main() {
    assertEquals(3, majorityElementBySort(intArrayOf(3, 2, 3)))
    assertEquals(2, majorityElementBySort(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}

private fun majorityElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()

    val majorityCount = (nums.size / 2) + 1
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0) + 1
        if (map[n] == majorityCount) {
            return n
        }
    }

    throw IllegalStateException("No majority element")
}

private fun majorityElementBySort(nums: IntArray): Int {
    nums.sort()
    return nums[nums.size / 2]
}