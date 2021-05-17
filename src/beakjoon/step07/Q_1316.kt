package beakjoon.step07

fun main() {
    var result = 0
    repeat(readLine()?.toInt() ?: 0) {
        if (isGroupWord(readLine()!!)) {
            ++result
        }
    }

    print(result)
}

private fun isGroupWord(str: String): Boolean {
    val arr = BooleanArray(26) { false }

    arr[str[0] - 'a'] = true

    for (i in 1 until str.length) {
        if (str[i - 1] != str[i]) {
            if (arr[str[i] - 'a']) {
                return false
            } else {
                arr[str[i] - 'a'] = true
            }
        }
    }

    return true
}
