package pocu.sort

fun main() {
    val arr = intArrayOf(4, 3, 1, 7, 6, 2, 5)
    insertionSort(arr)
    println(arr.contentToString())
}

private fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
//        println("i = $i")
        var j = i
        loop@ while (j > 0) {
//            print("${j - 1} / ${j}\t")
            if (arr[j - 1] > arr[j]) {
//                print("swap\t")
                swap(arr, j - 1, j)
                j--
            } else {
//                print("equal")
                break@loop
            }
        }
//        println()
    }
}
