package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

fun main() {
    val l1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val l2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    val r1 = ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(4) } } }
        }
    }
    MatcherAssert.assertThat(mergeTwoLists(l1, l2), Matchers.`is`(r1))
    MatcherAssert.assertThat(mergeTwoLists(null, null), Matchers.nullValue())
    MatcherAssert.assertThat(mergeTwoLists(null, ListNode(0)), Matchers.`is`(ListNode(0)))
}

private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val tempHead = ListNode(0)
    var curr = tempHead

    var i = l1
    var j = l2

    while (i != null && j != null) {
        if (i.value < j.value) {
            curr.next = i
            curr = i
            i = i.next

        } else {
            curr.next = j
            curr = j
            j = j.next
        }
    }

    curr.next = i ?: j

    return tempHead.next
}