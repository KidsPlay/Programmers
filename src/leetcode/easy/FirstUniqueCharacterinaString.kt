package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(0, Matchers.`is`(firstUniqChar("leetcode")))
    MatcherAssert.assertThat(2, Matchers.`is`(firstUniqChar("loveleetcode")))
    MatcherAssert.assertThat(-1, Matchers.`is`(firstUniqChar("aabb")))
}

private fun firstUniqChar(s: String): Int {

    val hm = hashMapOf<Char, Int>()
    s.forEach { hm[it] = hm.getOrDefault(it, 0) + 1 }

    s.forEachIndexed { index, c ->
        if (hm[c] == 1) {
            return index
        }
    }

    return -1

}