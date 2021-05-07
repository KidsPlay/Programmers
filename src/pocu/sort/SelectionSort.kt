package pocu.sort

fun main() {
    val arr = intArrayOf(4, 3, 1, 7, 6, 2, 5)
    selectionSort(arr)
    println(arr.contentToString())
}

private fun selectionSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        val minIndex = arr.findMinIndex(i)
        swap(arr, i, minIndex)
    }
}

private fun IntArray.findMinIndex(startIndex: Int): Int {
    var minIndex = startIndex
    var min = this[startIndex]

    for (i in startIndex + 1 until this.size) {
//        print("${this[i]}\t")
        if (this[i] < min) {
            minIndex = i
            min = this[i]
        }
    }
//    println()

    return minIndex
}
