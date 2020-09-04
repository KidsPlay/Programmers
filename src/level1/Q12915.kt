package level1

import kotlin.test.assertEquals
import kotlin.test.assertTrue

fun main(args: Array<String>) {

    val main = Q12915()
    assertTrue { arrayOf("car", "bed", "sun").contentEquals(main.solution(arrayOf("sun", "bed", "car"), 1)) }
    assertTrue { arrayOf("abcd", "abce", "cdx").contentEquals(main.solution(arrayOf("abce", "abcd", "cdx"), 2)) }
}

class Q12915 {

    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {arr ->
            arr.sort()
            arr.sortBy { str -> str[n] }
        }

//        val map = hashMapOf<String, MutableList<String>>()
//
//        for (str in strings) {
//            val key = str.substring(n, n + 1)
//            map[key]?.add(str) ?: map.put(key, mutableListOf(str))
//        }
//
//        val answer = mutableListOf<String>()
//        map.keys.sorted().forEach { key ->
//            map[key]?.sorted()?.forEach {
//                answer.add(it)
//            }
//        }
//
//        return answer.toTypedArray()
    }

}