package beakjoon.step22

import kotlin.math.min

fun main() {
    val (width, height) = readLine()!!.split(' ').map { it.toInt() }
    val arr = Array<CharArray?>(width) { null }
    repeat(width) {
        arr[it] = readLine()!!.toCharArray()
    }

    var minCheck = Int.MAX_VALUE
    for (i in 0..(width - 8)) {
        for (j in 0..(height - 8)) {
            minCheck = min(minCheck, calcPaintCount(arr, i, j))
        }
    }

    print(minCheck)
}

fun calcPaintCount(arr: Array<CharArray?>, i: Int, j: Int): Int {
    val pattern1 = charArrayOf('B', 'W')
    val pattern2 = charArrayOf('W', 'B')

    var changeCount1 = 0
    var changeCount2 = 0
    for (x in i..(i + 7)) {
        for (y in j..(j + 7)) {
            if (arr[x]!![y] != pattern1[(x + y) % 2]) {
                ++changeCount1
            }

            if (arr[x]!![y] != pattern2[(x + y) % 2]) {
                ++changeCount2
            }
        }
    }

    return min(changeCount1, changeCount2)
}
