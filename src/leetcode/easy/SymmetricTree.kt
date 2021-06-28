package leetcode.easy

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import java.util.*

fun main() {
    MatcherAssert.assertThat(true, Matchers.`is`(isSymmetricIterative(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(3)
        }
    })))

    MatcherAssert.assertThat(false, Matchers.`is`(isSymmetricIterative(TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(3)
        }
        right = TreeNode(2).apply {
            right = TreeNode(3)
        }
    })))

    MatcherAssert.assertThat(false, Matchers.`is`(isSymmetricIterative(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2)
        }
        right = TreeNode(2).apply {
            left = TreeNode(2)
        }
    })))

}

private fun isSymmetricIterative(root: TreeNode?): Boolean {

    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
    queue.add(root)
    queue.add(root)

    while (queue.isNotEmpty()) {
        val n1 = queue.poll()
        val n2 = queue.poll()

        if (n1 == null && n2 == null) continue
        if (n1 == null || n2 == null) return false
        if (n1.`val` != n2.`val`) return false

        queue.add(n1.left)
        queue.add(n2.right)
        queue.add(n2.right)
        queue.add(n1.left)
    }

    return true
}

private fun isSymmetricRecursive(root: TreeNode?): Boolean {
    return isMirror(root, root)
}

private fun isMirror(n1: TreeNode?, n2: TreeNode?): Boolean {
    if (n1 == null && n2 == null) return true
    if (n1 == null || n2 == null) return false

    return (n1.`val` == n2.`val`)
            && isMirror(n1.left, n2.right)
            && isMirror(n1.right, n2.left)
}

private fun isSymmetricByStr(root: TreeNode?): Boolean {
    val leftSb = StringBuilder()
    val rightSb = StringBuilder()

    postOrder(root?.left, leftSb)
    postOrderReverse(root?.right, rightSb)

    println(leftSb)
    println(rightSb)

    return leftSb.toString() == rightSb.toString()
}

fun postOrder(node: TreeNode?, sb: StringBuilder) {
    if (node == null) {
        sb.append("n")
        return
    }

    if (node.left != null || node.right != null) {
        postOrder(node.left, sb)
        postOrder(node.right, sb)
    }
    sb.append(node.`val`)
}

fun postOrderReverse(node: TreeNode?, sb: StringBuilder) {
    if (node == null) {
        sb.append("n")
        return
    }

    if (node.left != null || node.right != null) {
        postOrderReverse(node.right, sb)
        postOrderReverse(node.left, sb)
    }
    sb.append(node.`val`)
}
