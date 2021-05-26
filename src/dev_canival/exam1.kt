package dev_canival

import java.util.*

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(' ').map { it.toInt() }
    val arr = IntArray(N)
    val st = StringTokenizer(readLine()!!)
    var i = 0
    while (st.hasMoreTokens()) {
        arr[i] = st.nextToken().toInt()
        i++
    }

    solution(arr, N, K).forEach {
        print("$it ")
    }

//    assertContentEquals(listOf(4, 2, 3, 1), solution(intArrayOf(8, 6, 7, 1), 4, 3))
//    assertContentEquals(listOf(4, 1, 3, 5, 2), solution(intArrayOf(1, 7, 2, 1, 3), 5, 2))
//    assertContentEquals(listOf(2, 3, 4, 1, 7, 6, 5), solution(intArrayOf(6, 1, 4, 4, 8, 7, 7), 7, 7))
}

private fun solution(list: IntArray, N: Int, K: Int): MutableList<Int> {
    val left = mutableListOf<Pair<Int, Int>>()
    val right = mutableListOf<Pair<Int, Int>>()
    for ((index, n) in list.withIndex()) {
        if (index in 0 until K - 1) {
            left.add(Pair(index + 1, n))
        } else {
            right.add(Pair(index + 1, n))
        }
    }

    left.sortBy { it.second }
    right.sortBy { it.second }

    val result = mutableListOf<Int>()
    while (left.isNotEmpty() && right.isNotEmpty()) {
        if (left.first().second < right.first().second) {
            result.add(left.first().first)
            left.removeFirst()
        } else {
            result.add(right.first().first)
            right.removeFirst()
        }
    }

    left.forEach {
        result.add(it.first)
    }

    right.forEach {
        result.add(it.first)
    }

    return result
}