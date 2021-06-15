package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(validPalindrome("aba"), Matchers.`is`(true))
    MatcherAssert.assertThat(validPalindrome("abca"), Matchers.`is`(true))
    MatcherAssert.assertThat(validPalindrome("abc"), Matchers.`is`(false))
    MatcherAssert.assertThat(validPalindrome("a"), Matchers.`is`(true))
    MatcherAssert.assertThat(validPalindrome("abccbda"), Matchers.`is`(true))
    MatcherAssert.assertThat(validPalindrome("abccdba"), Matchers.`is`(true))
    MatcherAssert.assertThat(validPalindrome("abcdcba"), Matchers.`is`(true))
    MatcherAssert.assertThat(
        validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"),
        Matchers.`is`(true)
    )
}

private fun validPalindrome(s: String): Boolean {
    var i = -1
    var j = s.length

    while (++i <= --j) {
        if (s[i] != s[j]) {
            return isPalindrome(i + 1, j, s) || isPalindrome(i, j - 1, s)
        }
    }

    return true
}

private fun isPalindrome(startIndex: Int, endIndex: Int, s: String): Boolean {
    var i = startIndex - 1
    var j = endIndex + 1

    while (++i < --j) {
        if (s[i] != s[j]) {
            return false
        }
    }

    return true
}