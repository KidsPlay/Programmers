package beakjoon.step19

private lateinit var fArr: IntArray

fun main() {
    val num = readLine()!!.toInt()
    fArr = IntArray(num + 1) { -1 }
    println(fibonacciRecursive(num))
    println(fArr.contentToString())
}

private fun fibonacciRecursive(n: Int): Int {
    if (n <= 2) return 1
    if (fArr[n] != -1) return fArr[n]

    fArr[n] = fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1)

    return fArr[n]
}

private fun fibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n <= 2) return 1

    if (fArr[n - 2] == -1) {
        fArr[n - 2] = fibonacci(n - 2)
    }

    if (fArr[n - 1] == -1) {
        fArr[n - 1] = fibonacci(n - 1)
    }

    return fArr[n - 2] + fArr[n - 1]
}
