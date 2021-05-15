package beakjoon.step07

import kotlin.math.max

fun main() {
    val inputStr = readLine()!!.split(' ')
    val num1 = inputStr[0].reversed().toInt()
    val num2 = inputStr[1].reversed().toInt()
    print(max(num1, num2))
}