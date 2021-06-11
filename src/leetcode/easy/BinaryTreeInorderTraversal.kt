package leetcode.easy

import org.junit.Assert
import kotlin.test.assertEquals

fun main() {
    Assert.assertEquals(listOf(1, 3, 2), inorderTraversal(TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }))

    assertEquals(emptyList(), inorderTraversal(null))
    assertEquals(listOf(1), inorderTraversal(TreeNode(1)))
}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    inorder(root, list)

    return list
}

private fun inorder(node: TreeNode?, list: MutableList<Int>) {
    if (node != null) {
        inorder(node.left, list)
        list.add(node.`val`)
        inorder(node.right, list)
    }
}
