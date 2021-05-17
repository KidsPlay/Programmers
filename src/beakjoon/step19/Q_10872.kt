package beakjoon.step19

fun main() {
    val num = readLine()!!
    print(factorial(num.toInt()))
}

private fun factorial(n: Int): Int {
    if (n <= 1) return 1

    return n * factorial(n - 1)
}
