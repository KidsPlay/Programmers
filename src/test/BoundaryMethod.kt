package test

fun main() {

    val t1 = TestDao().apply {
        data1 = "AAA"
    }
    println("t1 = $t1")

    val t2 = TestDao().also {
        it.data1 = "BBB"
    }
    println("t2 = $t2")
}

data class TestDao(
    var data1: String? = null
)