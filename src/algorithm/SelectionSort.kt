package algorithm

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import java.util.*
import kotlin.test.assertEquals

fun main() {

    MatcherAssert.assertThat(
        SelectionSort.sort(arrayOf(6, 8, 3, 2, 1, 7, 5, 4, 9)),
        Matchers.`is`(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
    )
//    assertEquals(arrayOf(6, 8, 3, 2, 1, 7, 5, 4, 9), SelectionSort.sort(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))

}

object SelectionSort {

    fun sort(arr: Array<Int>): Array<Int> {

        var max = 0
        var maxIndex = 0

        for (index in arr.indices) {
            print("index = $index\t")
            for (j in 0 until arr.size - index) {
                if (arr[j] > max) {
                    max = arr[j]
                    maxIndex = j
                }
            }

            print("max = $max\t")
            swap(arr, maxIndex, arr.size - 1 - index)
            max = 0
            maxIndex = 0

            println(arr.contentToString())
        }

        return arr
    }

    private fun swap(arr: Array<Int>, index1: Int, index2: Int) {
        if (index1 == index2) return

        val temp = arr[index1]
        arr[index1] = arr[index2]
        arr[index2] = temp
    }

}