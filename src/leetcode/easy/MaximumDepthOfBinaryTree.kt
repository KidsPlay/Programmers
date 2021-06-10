package leetcode.easy

import kotlin.math.max
import kotlin.test.assertEquals

fun main() {
    assertEquals(3, maxDepth(TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }))

    assertEquals(2, maxDepth(TreeNode(1).apply {
        right = TreeNode(2)
    }))

    assertEquals(0, maxDepth(null))

    assertEquals(1, maxDepth(TreeNode(0)))
}

fun maxDepth(root: TreeNode?): Int {
    return checkDepthRecursive(root, 1)
}

fun checkDepthRecursive(node: TreeNode?, nextDepth: Int): Int {
    if (node == null) return nextDepth - 1

    val leftDepth = checkDepthRecursive(node.left, nextDepth + 1)
    val rightDepth = checkDepthRecursive(node.right, nextDepth + 1)

    return max(leftDepth, rightDepth)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}