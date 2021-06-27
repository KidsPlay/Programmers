package kakao.mobility

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    val c = University(RepositoryImpl())
    MatcherAssert.assertThat(
        mapOf(
            Course(name = "History") to 2,
            Course(name = "Arts") to 1,
            Course(name = "Biology") to 1
        ), Matchers.`is`(c.getPaidCoursesWithTheNumbersOfSubscribedStudents(3))
    )
}

class University(private val repository: Repository<Student>) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> {
        val map = hashMapOf<Course, Int>()

        val students = repository.get()
        for (s in students) {
            for (c in s.subscribedCourses) {
                if (c.isPaid) {
                    map[c] = map.getOrDefault(c, 0) + 1
                }
            }
        }

        return map.toList()
            .sortedWith(object : Comparator<Pair<Course, Int>> {
                override fun compare(o1: Pair<Course, Int>, o2: Pair<Course, Int>): Int {
                    return if (o1.second != o2.second) {
                        o2.second.compareTo(o1.second)
                    } else {
                        o1.first.name.compareTo(o2.first.name)
                    }
                }
            }).take(coursesCount)
            .toMap()
    }
}

data class Student(val id: Id = 0, val name: String = "A", val subscribedCourses: List<Course>)

data class Course(val id: Id = 0, val name: String, val isPaid: Boolean = true)

typealias Id = Int

interface Repository<T> {
    fun get(): Iterable<T>
}

class RepositoryImpl : Repository<Student> {
    override fun get(): Iterable<Student> {
        return listOf(
            Student(
                subscribedCourses = listOf(
                    Course(name = "Maths", isPaid = false),
                    Course(name = "Arts", isPaid = true)
                )
            ),
            Student(
                subscribedCourses = listOf(
                    Course(name = "History", isPaid = true),
                    Course(name = "Biology", isPaid = true)
                )
            ),
            Student(
                subscribedCourses = listOf(
                    Course(name = "Physics", isPaid = true),
                    Course(name = "History", isPaid = true)
                )
            )
        )
    }

}
