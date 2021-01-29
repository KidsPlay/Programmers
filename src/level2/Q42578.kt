package level2

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    val main = Solution()

    MatcherAssert.assertThat(
        main.solution(
            arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
            )
        ), Matchers.`is`(5)
    )

    MatcherAssert.assertThat(
        main.solution(
            arrayOf(
                arrayOf("crow_mask", "face"),
                arrayOf("blue_sunglasses", "face"),
                arrayOf("smoky_makeup", "face")
            )
        ), Matchers.`is`(5)
    )
}

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = mutableMapOf<String, MutableList<String>>()

        for (cloth in clothes) {
            map[cloth[1]] = map.getOrDefault(cloth[1], mutableListOf()).apply { add(cloth[0]) }
        }
        println(map)

        var answer = 0
        map.values.map {
            answer += it.size
        }

        for ((index, key) in map.keys.withIndex()) {
            
        }

        return answer
    }
}