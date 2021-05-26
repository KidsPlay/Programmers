package goorm

import kotlin.math.ceil
import kotlin.math.min
import kotlin.test.assertEquals

//37 4
//31 36 20 30 1 9 6 13 3 29 11 25 7 8 2 24 34 18 26 15 23 28 37 19 21 4 32 14 16 10 12 27 22 35 5 17 33

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(' ').map { it.toInt() }
    val arr = readLine()!!.split(' ').map { it.toInt() }

    print(solution(N, K, arr))

    assertEquals(2, solution(4, 3, listOf(2, 3, 1, 4)))
    assertEquals(4, solution(8, 3, listOf(7, 3, 1, 8, 4, 6, 2, 5)))
    assertEquals(
        12,
        solution(
            37,
            4,
            listOf(
                31,
                36,
                20,
                30,
                1,
                9,
                6,
                13,
                3,
                29,
                11,
                25,
                7,
                8,
                2,
                24,
                34,
                18,
                26,
                15,
                23,
                28,
                37,
                19,
                21,
                4,
                32,
                14,
                16,
                10,
                12,
                27,
                22,
                35,
                5,
                17,
                33
            )
        )
    )
}

private fun solution(N: Int, K: Int, arr: List<Int>): Int {
    val baseIndex = arr.indexOf(1)
    var minValue = Int.MAX_VALUE
    val interval = K - 1
    var left = baseIndex + 1
    var right = N - baseIndex - 1 - interval - 1

    for (n in 0 until K) {
        left -= 1
        right += 1

        val count = (ceil(left / interval.toDouble()) + 1 + ceil(right / interval.toDouble())).toInt()
        minValue = min(minValue, count)
    }

    return minValue
}