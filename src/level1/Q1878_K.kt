@file:Suppress("ClassName")

package level1

import org.junit.Assert

fun main() {
    val main = Q1878_K()

    Assert.assertArrayEquals(
        intArrayOf(1, 10),
        main.solution(arrayOf(intArrayOf(1, 4), intArrayOf(3, 4), intArrayOf(3, 10)))
    )

    Assert.assertArrayEquals(
        intArrayOf(2, 1),
        main.solution(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(1, 2)))
    )
}

class Q1878_K {
    fun solution(v: Array<IntArray>): IntArray {
        val x = v[0][0] xor v[1][0] xor v[2][0]
        val y = v[0][1] xor v[1][1] xor v[2][1]

        return intArrayOf(x, y)

//        val mapX = hashSetOf<Int>()
//        val mapY = hashSetOf<Int>()
//
//        for (arr in v){
//            if(mapX.contains(arr[0])){
//                mapX.remove(arr[0])
//            }else{
//                mapX.add(arr[0])
//            }
//
//            if(mapY.contains(arr[1])){
//                mapY.remove(arr[1])
//            }else{
//                mapY.add(arr[1])
//            }
//        }
//
//        return intArrayOf(mapX.first(), mapY.first())
    }
}