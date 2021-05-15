package beakjoon.step07

fun main() {
    readLine()?.let { inputStr ->
        print(inputStr.sumOf { it.toPhoneNumberUnit() + 1 })
    }
}

private fun Char.toPhoneNumberUnit(): Int {
    return when {
        this <= 'C' -> 2
        this <= 'F' -> 3
        this <= 'I' -> 4
        this <= 'L' -> 5
        this <= 'O' -> 6
        this <= 'S' -> 7
        this <= 'V' -> 8
        this <= 'Z' -> 9
        else -> 0
    }
}
