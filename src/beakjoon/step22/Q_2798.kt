package beakjoon.step22

fun main() {
    val (N, M) = readLine()!!.split(' ').map { it.toInt() }
    val nums = readLine()!!.split(' ').map { it.toInt() }.sorted()

//    println(nums)

    var max = Int.MIN_VALUE
    loopA@ for (a in 0 until N - 2) {
        for (b in a + 1 until N - 1) {
            loopC@ for (c in b + 1 until N) {
                val sum = nums[a] + nums[b] + nums[c]
//                println("num1 = ${nums[a]} / num2 = ${nums[b]} / num3 = ${nums[c]} / sum = $sum / max = $max")
                if (sum == M) {
                    max = M
                    break@loopA
                } else if (sum in (max + 1) until M) {
                    max = sum
                }else if(sum > max){
                    break@loopC
                }
            }
        }
    }
    print(max)
}