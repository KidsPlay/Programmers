package beakjoon.step07

fun main() {
    val croatiaRegex = "c=|c-|dz=|d-|lj|nj|s=|z=".toRegex()
    val result = readLine()?.replace(croatiaRegex, "*")

    println(result)
    print(result?.length ?: 0)
}

//fun main() {
//    val charArr = readLine()!!.toCharArray()
//    var wordCount = 0
//
//    var i = 0
//    while (i < charArr.size) {
//        val ch = charArr[i]
//
//        when {
//            (i < charArr.size - 1) && (
//                    (ch == 'c' && (charArr[i + 1] == '=' || charArr[i + 1] == '-')) ||
//                            (ch == 'd' && charArr[i + 1] == '-') ||
//                            (ch == 'l' && charArr[i + 1] == 'j') ||
//                            (ch == 'n' && charArr[i + 1] == 'j') ||
//                            (ch == 's' && charArr[i + 1] == '=') ||
//                            (ch == 'z' && charArr[i + 1] == '=')
//                    ) -> {
//                ++wordCount
//                i += 2
//            }
//
//            (i < charArr.size - 2) &&
//                    (ch == 'd' && charArr[i + 1] == 'z' && charArr[i + 2] == '=') -> {
//                ++wordCount
//                i += 3
//            }
//
//            else -> {
//                ++wordCount
//                ++i
//            }
//        }
//    }
//
//    print(wordCount)
//}