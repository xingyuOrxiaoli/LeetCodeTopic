package simple.A543;

import utils.TreeNode
import kotlin.math.max

class MethodVersion1 :  A543Solution{

    var res: Int = 0
    override fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return res
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        val left = dfs(root.left)
        val right = dfs(root.right)
        val temp = right + left
        res = max(res.toDouble(), temp.toDouble()).toInt()
        return (max(left.toDouble(), right.toDouble()) + 1).toInt()
    }
}