package beakjoon.step22

fun main() {
    val dataCount = readLine()!!.toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(dataCount) {
        val (weight, height) = readLine()!!.split(' ').map { it.toInt() }
        list.add(Pair(weight, height))
    }

    var level: Int
    for (i in 0 until dataCount) {
        level = 1

        for (j in 0 until dataCount) {
            if (i == j) continue

            if (list[i].first < list[j].first && list[i].second < list[j].second) {
                ++level
            }
        }

        if (i != 0) print(' ')
        print(level)
    }
}