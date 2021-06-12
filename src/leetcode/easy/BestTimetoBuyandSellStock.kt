package leetcode.easy

import kotlin.math.max
import kotlin.test.assertEquals

fun main() {
    assertEquals(5, maxProfitOnePass(intArrayOf(7, 1, 5, 3, 6, 4)))
    assertEquals(0, maxProfitOnePass(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfitOnePass(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    for (n in prices) {
        if (n < minPrice) {
            minPrice = n
        } else {
            maxProfit = max(n - minPrice, maxProfit)
        }
    }

    return maxProfit
}

private fun maxProfit(prices: IntArray): Int {
    var max = Int.MIN_VALUE
    for (i in prices.indices) {
        for (j in i + 1 until prices.size) {
            max = max(prices[j] - prices[i], max)
        }
    }

    return if (max > 0) max else 0
}