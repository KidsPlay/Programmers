package beakjoon.step07

import java.util.*

fun main() {
    with(Scanner(System.`in`)) {
        val charArr = next().toCharArray()

        for (ch in 'a'..'z') {
            print("${charArr.indexOfFirst { it == ch }} ")
        }
    }
}