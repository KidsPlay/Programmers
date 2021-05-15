package pocu.sort

fun main() {
    var arr = intArrayOf(4, 3, 1, 7, 6, 2, 5)
    arr = mergeSort(arr)
    println(arr.contentToString())
}

private fun mergeSort(arr: IntArray): IntArray {
    return mergeSortRecursive(arr, 0, arr.size - 1)
}

private fun mergeSortRecursive(arr: IntArray, start: Int, end: Int): IntArray {

    if (start == end) {
        return intArrayOf(arr[start])
    }

    val middle = (start + end) / 2

    val frontSortedArr: IntArray = mergeSortRecursive(arr, start, middle)
    val backSortedArr: IntArray = mergeSortRecursive(arr, middle + 1, end)

    return mergeSortTwoArrays(frontSortedArr, backSortedArr)
}

private fun mergeSortTwoArrays(frontSortedArr: IntArray, backSortedArr: IntArray): IntArray {
    val mergedArr = IntArray(frontSortedArr.size + backSortedArr.size)

    var frontIndex = 0
    var backIndex = 0
    var mergeIndex = 0

    while (frontIndex < frontSortedArr.size && backIndex < backSortedArr.size) {
        if (frontSortedArr[frontIndex] <= backSortedArr[backIndex]) {
            mergedArr[mergeIndex++] = frontSortedArr[frontIndex++]
        } else {
            mergedArr[mergeIndex++] = backSortedArr[backIndex++]
        }
    }

    for (i in frontIndex until frontSortedArr.size) {
        mergedArr[mergeIndex++] = frontSortedArr[i]
    }

    for (i in backIndex until backSortedArr.size) {
        mergedArr[mergeIndex++] = backSortedArr[i]
    }

    return mergedArr
}
