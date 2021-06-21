package test

fun main() {
    println("result = " + noSequence())
    println("===================================")
    println("result = " + withSequence())
}

fun noSequence() = (1..10)
    .filter {
        println("filter : $it -> ${it % 2}")
        it % 2 == 1
    }
    .map {
        println("map : $it -> ${it * 2}")
        it * 2
    }
    .take(2)

fun withSequence() = (1..10).asSequence()
    .filter {
        println("filter : $it -> ${it % 2}")
        it % 2 == 1
    }
    .map {
        println("map : $it -> ${it * 2}")
        it * 2
    }
    .take(2)
    .toList()