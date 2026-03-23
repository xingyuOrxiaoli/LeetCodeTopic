package medium.A501;

import utils.TreeNode
import java.util.*
import kotlin.math.max

class MethodVersion1 :  A501Solution{

    override fun findMode(root: TreeNode?): IntArray {
        val counts: MutableList<Int> = ArrayList()
        val values: MutableList<Int> = ArrayList()
        val res: MutableList<Int> = ArrayList()

        val stack = Stack<TreeNode>()
        stack.push(root)
        var pre = Int.MIN_VALUE
        var count = 0
        var max = 0
        while (!stack.isEmpty()) {
            val node = stack.pop()
            if (node.right != null) {
                stack.push(node.right)
            }

            if (node.left == null && node.right == null) {
                if (pre == Int.MIN_VALUE) {
                    count = 1
                    values.add(node.`val`)
                } else if (pre != node.`val`) {
                    counts.add(count)
                    max = max(max.toDouble(), count.toDouble()).toInt()
                    values.add(node.`val`)
                    count = 1
                } else {
                    count++
                }
                pre = node.`val`
            } else {
                stack.push(node)
            }
            if (node.left != null) {
                stack.push(node.left)
            }
            if (stack.isEmpty()) {
                max = max(max.toDouble(), count.toDouble()).toInt()
                counts.add(count)
            }
            node.left = null
            node.right = null
        }
        for (i in counts.indices) {
            if (counts[i] == max) {
                res.add(values[i])
            }
        }
        return res.stream().mapToInt { i: Int? -> i!! }.toArray()
    }
}