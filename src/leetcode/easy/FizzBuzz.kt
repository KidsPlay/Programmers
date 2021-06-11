package leetcode.easy

import kotlin.test.assertEquals

fun main() {
    assertEquals(listOf("1", "2", "Fizz"), fizzBuzz(3))
    assertEquals(listOf("1", "2", "Fizz", "4", "Buzz"), fizzBuzz(5))
    assertEquals(
        listOf(
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz"
        ), fizzBuzz(15)
    )
}

private fun fizzBuzz(n: Int): List<String> {
    return (1..n).map {
        when {
            it % 15 == 0 -> "FizzBuzz"
            it % 3 == 0 -> "Fizz"
            it % 5 == 0 -> "Buzz"
            else -> it.toString()
        }
    }.toList()
}