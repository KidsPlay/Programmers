package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    val result = listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1))
    MatcherAssert.assertThat(result, Matchers.`is`(generate(5)))

    MatcherAssert.assertThat(listOf(listOf(1)), Matchers.`is`(generate(1)))
}

private fun generate(numRows: Int): List<List<Int>> {

    val result = mutableListOf<List<Int>>()

    var preUnit: MutableList<Int>
    var resultUnit: MutableList<Int> = mutableListOf()

    for (n in 0 until numRows) {
        preUnit = resultUnit
        resultUnit = mutableListOf()

        for (i in 0..n) {
            if (i == 0 || i == n) {
                resultUnit.add(1)
            } else {
                resultUnit.add(preUnit[i - 1] + preUnit[i])
            }
        }

        result.add(resultUnit)
    }

    return result
}