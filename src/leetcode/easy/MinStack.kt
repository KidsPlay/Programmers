package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.min

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)

    MatcherAssert.assertThat(minStack.getMin(), Matchers.`is`(-3))

    minStack.pop()

    MatcherAssert.assertThat(minStack.top(), Matchers.`is`(0))

    MatcherAssert.assertThat(minStack.getMin(), Matchers.`is`(-2))

}

private class MinStack {
    var top: Node<Int>? = null
    var minValue = Int.MAX_VALUE

    fun push(`val`: Int) {
        minValue = min(minValue, `val`)

        val node = Node(`val`)
        node.next = top
        top = node
    }

    fun pop() {
        top = top?.next

        minValue = Int.MAX_VALUE
        var temp = top
        while (temp != null) {
            minValue = min(minValue, temp.value)
            temp = temp.next
        }
    }

    fun top(): Int {
        return top?.value ?: 0
    }

    fun getMin(): Int {
        return minValue
    }
}

private class Node<T>(val value: T) {
    var next: Node<T>? = null
}