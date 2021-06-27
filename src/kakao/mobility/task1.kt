package kakao.mobility

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    MatcherAssert.assertThat(
        "pom",
        Matchers.`is`(solution(arrayOf("pim", "pom"), arrayOf("999999999", "777888999"), "88999"))
    )

    MatcherAssert.assertThat(
        "ann",
        Matchers.`is`(
            solution(
                arrayOf("sander", "army", "ann", "micheal"),
                arrayOf("123456789", "234567890", "789123456", "123123123"),
                "1"
            )
        )
    )

    MatcherAssert.assertThat(
        "sander",
        Matchers.`is`(
            solution(
                arrayOf("sander", "army", "ann", "micheal"),
                arrayOf("123456789", "234567890", "789123456", "123123123"),
                "123456789"
            )
        )
    )

    MatcherAssert.assertThat(
        "army",
        Matchers.`is`(
            solution(
                arrayOf("sander", "army", "ann", "micheal"),
                arrayOf("123456789", "123456789", "133456789", "123456789"),
                "123456789"
            )
        )
    )

    MatcherAssert.assertThat(
        "NO CONTACT",
        Matchers.`is`(
            solution(
                arrayOf("adam", "eva", "leo"),
                arrayOf("121212121", "111111111", "444555666"),
                "112"
            )
        )
    )
}

private fun solution(A: Array<String>, B: Array<String>, P: String): String {
    val map = hashMapOf<String, String>()

    for (i in A.indices) {
        map[A[i]] = B[i]
    }

    A.sort()
    for (name in A) {
        if (map[name]!!.indexOf(P) != -1) {
            return name
        }
    }

    return "NO CONTACT"
}