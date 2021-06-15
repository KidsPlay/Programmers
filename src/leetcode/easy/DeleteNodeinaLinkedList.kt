package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    var head = ListNode.make(intArrayOf(4, 5, 1, 9))
    deleteNode(head.next)
    MatcherAssert.assertThat(head, Matchers.`is`(ListNode.make(intArrayOf(4, 1, 9))))

    head = ListNode.make(intArrayOf(4, 5, 1, 9))
    deleteNode(head.next?.next)
    MatcherAssert.assertThat(head, Matchers.`is`(ListNode.make(intArrayOf(4, 5, 9))))

    head = ListNode.make(intArrayOf(1, 2, 3, 4))
    deleteNode(head.next?.next)
    MatcherAssert.assertThat(head, Matchers.`is`(ListNode.make(intArrayOf(1, 2, 4))))

    head = ListNode.make(intArrayOf(0, 1))
    deleteNode(head)
    MatcherAssert.assertThat(head, Matchers.`is`(ListNode.make(intArrayOf(1))))

    head = ListNode.make(intArrayOf(-3, 5, -99))
    deleteNode(head)
    MatcherAssert.assertThat(head, Matchers.`is`(ListNode.make(intArrayOf(5, -99))))
}

private fun deleteNode(node: ListNode?) {
    node?.let {
        it.`val` = it.next!!.`val`
        it.next = it.next?.next
    }
}