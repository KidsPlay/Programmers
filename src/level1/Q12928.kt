package level1

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val main = Q12928()
    assertEquals(0, main.solution(0))
    assertEquals(1, main.solution(1))
    assertEquals(3, main.solution(2))
    assertEquals(4, main.solution(3))
    assertEquals(7, main.solution(4))
    assertEquals(6, main.solution(5))
    assertEquals(12, main.solution(6))
    assertEquals(28, main.solution(12))
}

class Q12928 {
    fun solution(n: Int): Int {
        return (1..n).filter { n % it == 0 }.sum()

//        if (n <= 1) return n
//
//        val set = hashSetOf<Int>()
//        var answer = 0
//
//        for (i in 1..n) {
//            if (n % i == 0) {
//                if (!set.contains(i)) {
//                    val mok = n / i
//                    answer += i
//                    set.add(i)
//
//                    if(i != mok){
//                        answer += mok
//                        set.add(mok)
//                    }
//
//                } else {
//                    break
//                }
//            }
//        }
//
//        return answer
    }
}