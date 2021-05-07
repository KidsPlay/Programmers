package interview.coupang.d_20210206

import org.junit.Assert

fun main() {
    val main = Exam1()

    Assert.assertEquals(3, main.solution(intArrayOf(1, 10, 2, 9, 3, 8, 4, 7, 5, 6), 20))
}

class Exam1 {
    fun solution(A: IntArray, S: Int): Int {
        var answer = Int.MAX_VALUE
        var sum: Int

        for (i in A.indices) {
            sum = 0
            loop@ for (j in i until A.size) {
                val len = j - i + 1
                sum += A[j]

                if (len > answer) {
                    break@loop
                }

                if (sum >= S) {
                    if (len < answer) {
                        answer = len
                    }
                    break@loop
                }
            }
        }

        return if (answer == Int.MAX_VALUE) 0 else answer

//        var answer: Int = Int.MAX_VALUE
//        val sumArr = arrayListOf<Int>()
//
//        var sum = 0
//        for (num in A){
//            sum += num
//            sumArr.add(sum)
//        }
//
//        for(i in A.indices){
//            val cSum = sumArr[i]
//            if(cSum > S){
//                loop@for (j in i-1 downTo 0){
//                    if(cSum - sumArr[j] >= S){
//                        val len = i - j
//                        if(len < answer){
//                            answer = len
//                        }
//                        break@loop
//                    }
//                }
//            }
//        }
//
//        return if(answer == Int.MAX_VALUE) 0 else answer
    }
}