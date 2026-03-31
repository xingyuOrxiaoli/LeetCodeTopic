package simple.A617;

import utils.TreeNode

class MethodVersion1 :  A617Solution{

    override fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null) {
            return root2
        } else if (root2 == null) {
            return root1
        }
        root1.`val` += root2.`val`

        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)
        return root1
    }
}