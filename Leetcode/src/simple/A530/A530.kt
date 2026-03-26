package simple.A530;

import utils.TreeNode
import kotlin.math.abs
import kotlin.math.min

class MethodVersion1 :  A530Solution{
    var res: Int = Int.MAX_VALUE
    var pre: Int = -100000
     override fun getMinimumDifference(root: TreeNode?): Int {
        dfs(root)
        return res
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) {
            return
        }
        dfs(root.left)
        res = min(res.toDouble(), abs((root.`val` - pre).toDouble())).toInt()
        pre = root.`val`
        dfs(root.right)
    }
}