package pocu.sort

fun main() {
    val arr = intArrayOf(4, 3, 1, 7, 6, 2, 5)
    bubbleSort(arr)
    println(arr.contentToString())
}

private fun bubbleSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i - 1) {
            println("check = ${j} / ${j + 1}")
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1)
            }
        }
    }
}

internal fun swap(arr: IntArray, index1: Int, index2: Int) {
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}