package interview.coupang.d_20210206

import org.junit.Assert

fun main() {
    val main = Exam2()

    Assert.assertArrayEquals(
        arrayOf("DS7651 A+", "OS1808 B-", "DB0001 B-", "AI5543 C0", "CA0055 D+", "AI0001 F"),
        main.solution(
            arrayOf(
                "DS7651 A0",
                "CA0055 D+",
                "AI5543 C0",
                "OS1808 B-",
                "DS7651 B+",
                "AI0001 F",
                "DB0001 B-",
                "AI5543 D+",
                "DS7651 A+",
                "OS1808 B-"
            )
        )
    )

    Assert.assertArrayEquals(
        arrayOf("GP0000 A0", "PL6677 B+", "DM0106 B+"),
        arrayOf("DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0")
    )
}

class Exam2 {

    data class Subject(val no: String, val grade: String)

    fun solution(grades: Array<String>): Array<String> {
        val map = hashMapOf<String, String>()

        grades.map {
            val list = it.split(" ")
            val no = list[0]
            val grade = list[1]

            if (map.contains(no)) {

            } else {
                map.put(no, grade)
            }
        }

        val a = map.mapKeys {
            "${it.key} ${it.value}"
        }.toList()

//        map.map { key, value ->
//            "$key $value"
//        }.

        var answer: Array<String> = arrayOf<String>()
        return answer
    }
}