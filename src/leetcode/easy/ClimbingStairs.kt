package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(climbStairs(2), Matchers.`is`(2))
    MatcherAssert.assertThat(climbStairs(3), Matchers.`is`(3))
    MatcherAssert.assertThat(climbStairs(4), Matchers.`is`(5))
    MatcherAssert.assertThat(climbStairs(5), Matchers.`is`(8))
    MatcherAssert.assertThat(climbStairs(6), Matchers.`is`(13))
//    MatcherAssert.assertThat(climbStairs(7), Matchers.`is`(13))
}

private fun climbStairs(n: Int): Int {
    val set = hashMapOf<Int, Int>()

    return climbStairsRecursive(0, n, set)
}

private fun climbStairsRecursive(currentStair: Int, topStair: Int, cache: HashMap<Int, Int>): Int {

    if (currentStair > topStair) {
        return 0
    }

    if (currentStair == topStair) {
        return 1
    }

    if (!cache.contains(currentStair)) {
        cache[currentStair] = climbStairsRecursive(currentStair + 1, topStair, cache) +
                climbStairsRecursive(currentStair + 2, topStair, cache)
    }

    return cache[currentStair]!!
}