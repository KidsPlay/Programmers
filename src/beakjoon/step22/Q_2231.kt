package beakjoon.step22

fun main() {
    val M = readLine()!!.toInt()

    var result = 0
    for (N in 1..M) {
//        println("N = $N / divideSum(N) = ${divideSum(N)}")
        if (N + divideSum(N) == M) {
            result = N
            break
        }
    }

    print(result)
}

private fun divideSum(num: Int): Int {
    var temp = num
    var sum = 0
    while (temp != 0) {
        sum += temp % 10
        temp /= 10
    }

    return sum
//    return num.toString().sumOf { it - '0' }
}
