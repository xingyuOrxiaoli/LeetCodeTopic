package simple.A110

import utils.TreeNode


fun depth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = depth(root.left)
    val right = depth(root.right)
    if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1
    return Math.max(left,right) + 1
}

fun isBalanced(root: TreeNode?): Boolean {
    return depth(root) >= 0
}

fun main() {
    val root: TreeNode = TreeNode(3)

}
