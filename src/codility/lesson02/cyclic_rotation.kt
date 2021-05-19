package codility.lesson02

import org.junit.Assert

fun solution(A: IntArray, K: Int): IntArray {
    if(A.size == K){
        return A
    }

    val result = IntArray(A.size)
    for ((index, n) in A.withIndex()){
        result[(index + K) % A.size] = n
    }

    return result
}

fun main() {
    Assert.assertArrayEquals(intArrayOf(9, 7, 6, 3, 8), solution(intArrayOf(3, 8, 9, 7, 6), 3))
    Assert.assertArrayEquals(intArrayOf(0, 0, 0), solution(intArrayOf(0, 0, 0), 1))
    Assert.assertArrayEquals(intArrayOf(1, 2, 3, 4), solution(intArrayOf(1, 2, 3, 4), 4))
}
