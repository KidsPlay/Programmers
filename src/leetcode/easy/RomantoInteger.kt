package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(romanToInt2("III"), Matchers.`is`(3))
    MatcherAssert.assertThat(romanToInt2("IV"), Matchers.`is`(4))
    MatcherAssert.assertThat(romanToInt2("IX"), Matchers.`is`(9))
    MatcherAssert.assertThat(romanToInt2("LVIII"), Matchers.`is`(58))
    MatcherAssert.assertThat(romanToInt2("MCMXCIV"), Matchers.`is`(1994))
}

private val romanMap = HashMap<Char, Int>().apply {
    put('I', 1)
    put('V', 5)
    put('X', 10)
    put('L', 50)
    put('C', 100)
    put('D', 500)
    put('M', 1000)
}

private fun romanToInt2(s: String): Int {
    var result: Int = romanMap[s[s.length - 1]]!!
    for (i in s.length - 2 downTo 0) {
        if (romanMap[s[i]]!! < romanMap[s[i + 1]]!!) {
            result -= romanMap[s[i]]!!
        } else {
            result += romanMap[s[i]]!!
        }
    }
    return result
}

//private fun romanToInt(s: String): Int {
//    var result = 0
//    var i = s.length - 1
//    while (i >= 0) {
//        var num = 0
//
//        if (i > 0) {
//            num = romanMap.getOrDefault(s.substring(i - 1, i + 1), 0)
//        }
//
//        if (num == 0) {
//            num = romanMap[s.substring(i, i + 1)] ?: 0
//            i--
//        } else {
//            i -= 2
//        }
//
//        result += num
//    }
//
//    return result
//}