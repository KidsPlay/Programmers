package beakjoon.step07

import java.util.*

fun main() {
    with(Scanner(System.`in`)) {
        val count = nextInt()
        print(next().toCharArray().sumOf { it.toString().toInt() })
    }
}