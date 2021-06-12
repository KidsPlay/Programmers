package leetcode.easy

import kotlin.test.assertContentEquals

fun main() {
    assertContentEquals(intArrayOf(1, 3, 12, 0, 0), moveZeroes(intArrayOf(0, 1, 0, 3, 12)))
    assertContentEquals(intArrayOf(0), moveZeroes(intArrayOf(0)))
}

private fun moveZeroes(nums: IntArray): IntArray {
    var baseIndex = 0

    for ((i, n) in nums.withIndex()) {
        if (n != 0) {
            pocu.sort.swap(nums, baseIndex, i)
            baseIndex++
        }
    }

    return nums
}