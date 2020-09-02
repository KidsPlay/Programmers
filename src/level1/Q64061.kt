package level1

import java.util.*
import kotlin.test.assertEquals

fun main(args: Array<String>) {
//        [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4]
    val board1 = intArrayOf(0, 0, 0, 0, 0)
    val board2 = intArrayOf(0, 0, 1, 0, 3)
    val board3 = intArrayOf(0, 2, 5, 0, 1)
    val board4 = intArrayOf(4, 2, 4, 4, 2)
    val board5 = intArrayOf(3, 5, 1, 3, 1)
    val board = arrayOf(board1, board2, board3, board4, board5)

    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)

    assertEquals(4, Q64061().solution(board, moves))
}

class Q64061 {

    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        for (move in moves) {
            val popValue = pop(board, move)

            if (stack.isEmpty()) {
                stack.push(popValue)
                continue
            }

            if (popValue != 0) {
                if (popValue == stack.peek()) {
                    stack.pop()
                    answer += 2
                } else {
                    stack.push(popValue)
                }
            }
        }

        return answer
    }

    private fun pop(board: Array<IntArray>, move: Int): Int {
        val index = move - 1

        var popValue = 0
        for (array in board) {
            if (array[index] != 0) {
                popValue = array[index]
                array[index] = 0
                break
            }
        }

        return popValue
    }

}