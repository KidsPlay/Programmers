package level1

import kotlin.math.floor
import kotlin.math.sqrt
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12934()
    assertEquals(144, main.solution(121))
    assertEquals(-1, main.solution(3))
}

class Q12934 {
    fun solution(n: Long): Long {
        val squared = sqrt(n.toDouble())
        return if (squared == floor(squared)) {
            ((squared + 1) * (squared + 1)).toLong()
        } else {
            -1
        }

//        var i = 1L
//        while (true) {
//            val squared = i * i
//            if (squared == n) {
//                i += 1
//                return i * i
//
//            } else if (squared > n) {
//                return -1
//
//            }
//
//            i++
//        }
    }
}