package leetcode.easy

import org.junit.Assert

fun main() {
    Assert.assertArrayEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')))
    Assert.assertArrayEquals(
        charArrayOf('h', 'a', 'n', 'n', 'a', 'H'),
        reverseString(charArrayOf('H', 'a', 'n', 'n', 'a', 'h'))
    )

}

private fun reverseString(s: CharArray): CharArray {
    var start = 0
    var end = s.size - 1

    while (start < end) {
        swap(s, start, end)
        start++
        end--
    }

    return s
}

private fun swap(arr: CharArray, start: Int, end: Int) {
    val temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
}
