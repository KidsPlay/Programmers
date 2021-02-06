package lessons_10302

import org.junit.Assert
import java.util.*

fun main() {
    val main = Q62951_K();

    Assert.assertEquals(
        11,
        main.solution(
            arrayOf(
                arrayOf(1, 0, 1, 1, 1),
                arrayOf(1, 0, 1, 0, 1),
                arrayOf(1, 0, 1, 1, 1),
                arrayOf(1, 1, 1, 0, 1),
                arrayOf(0, 0, 0, 0, 1)
            )
        )
    )

    Assert.assertEquals(
        -1,
        main.solution(
            arrayOf(
                arrayOf(1, 0, 1, 1, 1),
                arrayOf(1, 0, 1, 0, 1),
                arrayOf(1, 0, 1, 1, 1),
                arrayOf(1, 1, 1, 0, 0),
                arrayOf(0, 0, 0, 0, 1)
            )
        )
    )
}

class Q62951_K {
    fun solution(maps: Array<Array<Int>>): Int {

        val direction = arrayOf(
            Pair(1, 0), //동
            Pair(-1, 0), //서
            Pair(0, 1), //남
            Pair(0, -1)  //북
        )

        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.offer(Pair(0, 0))

        while (q.isNotEmpty()) {
            val pair = q.poll()
            val x = pair.first
            val y = pair.second

            for (d in direction) {
                val dx = x + d.first
                val dy = y + d.second

                if (dx in maps.indices && dy in maps[0].indices && maps[dx][dy] == 1) {
                    maps[dx][dy] = maps[x][y] + 1
                    q.offer(Pair(dx, dy))
                }
            }
        }

        for (m in maps){
            for(n in m){
                print("$n\t")
            }
            println()
        }
        println()
        println()

        val goalValue = maps[maps.size - 1][maps.size - 1]
        return if (goalValue != 1) goalValue else -1
    }
//    public int solution(int[][] maps) {
}