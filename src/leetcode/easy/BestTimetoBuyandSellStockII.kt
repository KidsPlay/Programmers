package leetcode.easy

import kotlin.math.max
import kotlin.test.assertEquals

fun main() {
    assertEquals(7, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    assertEquals(4, maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    var valley: Int
    var peak: Int
    var maxProfit = 0
    var i = 0

    while (i < prices.size) {
        while (i < prices.size - 1 && prices[i] > prices[i + 1]) {
            i++
        }
        valley = prices[i]

        while (i < prices.size - 1 && prices[i] < prices[i + 1]) {
            i++
        }
        peak = prices[i]

        val profit = peak - valley
        maxProfit += profit
        i++
    }

    return maxProfit
}

private fun maxProfitBruteForce(prices: IntArray): Int {
    return maxProfitRecursive(prices, 0)
}

private fun maxProfitRecursive(prices: IntArray, start: Int): Int {
    var maxProfit = 0

    for (i in start until prices.size) {
        for (j in i + 1 until prices.size) {
            if (prices[j] > prices[i]) {
                val profit = (prices[j] - prices[i]) + maxProfitRecursive(prices, j + 1)
                maxProfit = max(profit, maxProfit)
            }
        }
    }

    return maxProfit
}
