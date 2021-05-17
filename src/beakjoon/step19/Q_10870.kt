package beakjoon.step19

private lateinit var fArr: LongArray

fun main() {
    val num = readLine()!!.toInt()
    fArr = LongArray(num + 1) { -1L }
    print(fibonacci(num))
}

private fun fibonacci(n: Int): Long {
    if (n == 0) return 0
    if (n <= 2) return 1

    if (fArr[n - 2] == -1L) {
        fArr[n - 2] = fibonacci(n - 2)
    }

    if (fArr[n - 1] == -1L) {
        fArr[n - 1] = fibonacci(n - 1)
    }

    return fArr[n - 2] + fArr[n - 1]
}
