@file:Suppress("ClassName")

package level1

import org.junit.Assert

fun main() {
    val main = Q1877_K()

    Assert.assertEquals(true, main.solution(intArrayOf(4, 1, 3, 2)))
    Assert.assertEquals(false, main.solution(intArrayOf(4, 1, 3)))
}

class Q1877_K {
    fun solution(arr: IntArray): Boolean {
        return arr.sorted().filterIndexed { index, num -> index + 1 != num }.isEmpty()

//        var answer = true
//
//        arr.sort()
//
//        for ((index, num) in arr.withIndex()) {
//            if (num != index + 1) {
//                answer = false
//                break
//            }
//        }
//
//        return answer
    }
}