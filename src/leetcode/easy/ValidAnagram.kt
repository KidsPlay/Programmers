package leetcode.easy

import kotlin.test.assertEquals

fun main() {
    assertEquals(true, isAnagramByArray("anagram", "nagaram"))
    assertEquals(false, isAnagramByArray("rat", "car"))
}

private fun isAnagram(s: String, t: String): Boolean {
    val sArr = s.toCharArray().apply { sort() }
    val tArr = t.toCharArray().apply { sort() }

    return sArr.contentEquals(tArr)
}

private fun isAnagramByArray(s: String, t: String): Boolean {
    if(s.length != t.length) return false

    val arr = IntArray(26)

    for(i in s.indices){
        arr[s[i] - 'a']++
        arr[t[i] - 'a']--
    }

    return arr.indexOfFirst { it > 0 } == -1
}