package beakjoon.step01

import java.util.Scanner

fun main() {
    with(Scanner(System.`in`)){
        val num1 = nextInt()
        val num2 = nextInt()

        println(num1 + num2)
        println(num1 - num2)
        println(num1 * num2)
        println(num1 / num2)
        println(num1 % num2)
    }
}