package simple.A559;

import utils.Node
import java.util.*
import kotlin.math.max

class MethodVersion1 :  A559Solution{

    override fun maxDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }
        var res = 0
        val q: Queue<Node> = LinkedList()
        val levels: Queue<Int> = LinkedList()
        q.offer(root)
        levels.offer(1)
        while (!q.isEmpty()) {
            val cur = q.poll()
            val level = levels.poll()
            res = max(res.toDouble(), level.toDouble()).toInt()
            for (child in cur.children) {
                if (child != null) {
                    q.offer(child)
                    levels.offer(level + 1)
                }
            }
        }
        return res
    }
}