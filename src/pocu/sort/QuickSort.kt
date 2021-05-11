package pocu.sort

fun main() {
    val arr = intArrayOf(4, 3, 1, 7, 6, 2, 5)
    quickSort(arr)
    println(arr.contentToString())
}

private fun quickSort(arr: IntArray) {
    quickSortRecursive(arr, 0, arr.size - 1)
}

private fun quickSortRecursive(arr: IntArray, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    val pivot: Int = partition(arr, left, right)

    quickSortRecursive(arr, 0, pivot - 1)
    quickSortRecursive(arr, pivot + 1, right)
}

private fun partition(arr: IntArray, left: Int, right: Int): Int {
    val pivot = arr[right]
    var b = left - 1

    for (i in left until right){
        if(arr[i] < pivot){
            ++b
            swap(arr, b, i)
        }
    }

    swap(arr, ++b, right)

    return b
}
