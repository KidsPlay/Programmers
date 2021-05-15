package beakjoon.step07

/*
2
3 ABC
5 /HTP
 */
fun main() {
    val count = readLine()!!
    repeat(count.toInt()) {
        val (loopCount, inputStr) = readLine()!!.split(" ")

        inputStr.forEach { ch ->
            repeat(loopCount.toInt()) {
                print(ch)
            }
        }
        println()
    }
}