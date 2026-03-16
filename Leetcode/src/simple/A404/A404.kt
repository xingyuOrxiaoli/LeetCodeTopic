package simple.A404

import utils.TreeNode

class MethodVersion : A404Solution {
    override fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root?.left == null && root?.right == null) {
            return 0
        }
        return dfs(root, false)
    }

    private fun dfs(root: TreeNode?, isLeft: Boolean): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.`val`
        }

        var res = 0
        if (root.left != null) {
            res += dfs(root.left, true)
        }

        if (root.right != null) {
            res += dfs(root.right, false)
        }

        return res
    }
}