package level1

import kotlin.test.assertTrue

fun main(args: Array<String>) {

    val main = Q42840()
    assertTrue { intArrayOf(1).contentEquals(main.solution(intArrayOf(1, 2, 3, 4, 5))) }
    assertTrue { intArrayOf(1, 2, 3).contentEquals(main.solution(intArrayOf(1, 3, 2, 4, 2))) }
}

class Q42840 {
    fun solution(answers: IntArray): IntArray {
        val pattern1 = intArrayOf(1, 2, 3, 4, 5)
        val pattern2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val pattern3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val studentPatterns = arrayOf(pattern1, pattern2, pattern3)

        var maxAnswer = 0
        val winners = arrayListOf<Int>()

        for ((studentIndex, studentAnswer) in studentPatterns.withIndex()) {
            val correctAnswer = answers.filterIndexed { answerIndex, answer ->
                answer == studentAnswer[answerIndex % studentAnswer.size]
            }.count()

            val studentNumber = studentIndex + 1
            if (correctAnswer > maxAnswer) {
                winners.clear()
                winners.add(studentNumber)
                maxAnswer = correctAnswer

            } else if (correctAnswer == maxAnswer) {
                winners.add(studentNumber)
            }
        }

        return winners.toIntArray()
    }
}