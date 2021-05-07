package beakjoon.step04

import java.util.*

//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
fun main() {
    with(Scanner(System.`in`)) {
        val score = nextInt()

        when {
            score >= 90 -> {
                print("A")
            }
            score >= 80 -> {
                print("B")
            }
            score >= 70 -> {
                print("C")
            }
            score >= 60 -> {
                print("D")
            }
            else -> {
                print("F")
            }
        }
    }
}