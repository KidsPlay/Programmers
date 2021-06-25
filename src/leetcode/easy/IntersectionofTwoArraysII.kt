package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.min

fun main() {
    MatcherAssert.assertThat(
        intArrayOf(2, 2),
        Matchers.`is`(intersectByArray(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    )
    MatcherAssert.assertThat(
        intArrayOf(4, 9),
        Matchers.`is`(intersectByArray(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)))
    )

    MatcherAssert.assertThat(
        intArrayOf(0, 0),
        Matchers.`is`(intersectByArray(intArrayOf(0, 0, 0, 5), intArrayOf(9, 0, 0)))
    )
}

private fun intersectByArray(nums1: IntArray, nums2: IntArray): IntArray {
    val arr1 = IntArray(1001)
    val arr2 = IntArray(1001)

    nums1.forEach { arr1[it] = arr1[it] + 1 }
    nums2.forEach { arr2[it] = arr2[it] + 1 }

    val result = mutableListOf<Int>()
    for (i in 0..1000) {
        if (arr1[i] != 0 && arr2[i] != 0) {
            val repeat = min(arr1[i], arr2[i])
            repeat(repeat) {
                result.add(i)
            }
        }
    }

    return result.toIntArray()
}

private fun intersectByMap(nums1: IntArray, nums2: IntArray): IntArray {
    val hm = hashMapOf<Int, Int>()
    val result = mutableListOf<Int>()

    nums1.forEach { hm[it] = hm.getOrDefault(it, 0) + 1 }
    nums2.forEach {
        if (hm.getOrDefault(it, 0) > 0) {
            hm[it] = hm[it]!!.minus(1)
            result.add(it)
        }
    }

    return result.toIntArray()
}

private fun intersectBySort(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()

    var i = 0
    var j = 0
    val result = mutableListOf<Int>()

    while (i < nums1.size && j < nums2.size) {
        when {
            nums1[i] == nums2[j] -> {
                result.add(nums1[i])
                i++
                j++
            }
            nums1[i] < nums2[j] -> {
                i++
            }
            else -> {
                j++
            }
        }
    }

    return result.toIntArray()
}