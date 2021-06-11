package leetcode.easy

import java.lang.StringBuilder
import java.util.*
import kotlin.test.assertEquals

fun main() {
    assertEquals(ListNode(5).apply {
        next = ListNode(4).apply { next = ListNode(3).apply { next = ListNode(2).apply { next = ListNode(1) } } }
    }, reverseList(ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
    }))

    assertEquals(ListNode(2).apply {
        next = ListNode(1)
    }, reverseList(ListNode(1).apply {
        next = ListNode(2)
    }))

    assertEquals(null, reverseList(null))
}

private fun reverseList(head: ListNode?): ListNode? {
    var pre: ListNode? = null
    var curr = head

    while (curr != null) {
        val tempNext = curr.next

        curr.next = pre
        pre = curr
        curr = tempNext
    }

    return pre
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val sb = StringBuilder()
        var curr: ListNode? = this
        while (curr != null) {
            sb.append(curr.`val`)
            curr = curr.next
        }

        return sb.toString()
    }
}