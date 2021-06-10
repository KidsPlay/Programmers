package leetcode.easy

import kotlin.test.assertEquals

fun main() {
    assertEquals(1, singleNumber(intArrayOf(2, 2, 1)))
    assertEquals(4, singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    assertEquals(1, singleNumber(intArrayOf(1)))
}

private fun singleNumber(nums: IntArray): Int {
    val map = HashMap<Int, Boolean>()

    for (n in nums) {
        if (map.containsKey(n)) {
            map.remove(n)
        } else {
            map[n] = true
        }
    }

    return map.keys.first()
}