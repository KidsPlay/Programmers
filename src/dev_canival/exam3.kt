package dev_canival

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(' ').map { it.toInt() }

    print((solutionRecursive(N, K, 0, true) + solutionRecursive(N, K, 0, false)) % 1000000007)
}

/**
 * @param n - 남은반복회차
 * @param k - 연속결근 가능일
 * @param fail - 현재 연속 결근일
 * @param chul - 현재 출석여부
 */
private fun solutionRecursive(n: Int, k: Int, fail: Int, chul: Boolean): Int {
    if (n <= 1) return 1

    val f = if (!chul) {
        fail + 1
    } else {
        fail
    }

    return if (fail < k - 1) {
        solutionRecursive(n - 1, k, f, true) + solutionRecursive(n - 1, k, f, false)
    } else {
        solutionRecursive(n - 1, k, f, true)
    }
}
