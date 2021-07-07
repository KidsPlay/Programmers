package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.abs

fun main() {
//    MatcherAssert.assertThat(
//        getIntersectionNode(
//            ListNode.make(intArrayOf(4, 1, 8, 4, 5)),
//            ListNode.make(intArrayOf(5, 6, 1, 8, 4, 5))
//        )!!.`val`, Matchers.`is`(ListNode(8).`val`)
//    )
//
//    MatcherAssert.assertThat(
//        getIntersectionNode(
//            ListNode.make(intArrayOf(1, 9, 1, 2, 4)),
//            ListNode.make(intArrayOf(3, 2, 4))
//        )!!.`val`, Matchers.`is`(ListNode(2).`val`)
//    )
//
//    MatcherAssert.assertThat(
//        getIntersectionNode(
//            ListNode.make(intArrayOf(2, 6, 4)),
//            ListNode.make(intArrayOf(1, 5))
//        ), Matchers.nullValue()
//    )
}

private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var aCount = 0
    var bCount = 0
    var aNode = headA
    var bNode = headB

    while (aNode != null) {
        aCount++
        aNode = aNode.next
    }

    while (bNode != null) {
        bCount++
        bNode = bNode.next
    }

    val diffLength = abs(aCount - bCount)

    aNode = headA
    bNode = headB
    repeat(diffLength) {
        if (aCount > bCount) {
            aNode = aNode?.next
        } else {
            bNode = bNode?.next
        }
    }

    while(aNode != null){
        if(aNode === bNode){
            return aNode
        }
        aNode = aNode?.next
        bNode = bNode?.next
    }

    return null
}