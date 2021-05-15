package beakjoon.step07

fun main() {
    val arr = IntArray(26) //알파벳 개수 A~Z
    readLine()?.toUpperCase()?.toCharArray()?.forEach {
        arr[it - 'A'] += 1
    }

    var maxChar = 'A'
    var maxCount = -1
    for ((index, count) in arr.withIndex()) {
        if (count > maxCount) {
            maxCount = count
            maxChar = (index + 'A'.toInt()).toChar()
        } else if (count == maxCount) {
            maxChar = '?'
        }
    }

    print(maxChar)
}