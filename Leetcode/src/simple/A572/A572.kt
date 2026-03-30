package simple.A572;


import utils.TreeNode
import java.util.*
import kotlin.math.max
import kotlin.math.roundToInt

class MethodVersion1 :  A572Solution{

    override fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun check(right: TreeNode?, subRoot: TreeNode?): Boolean {
        if (right == null && subRoot == null) {
            return true
        }
        if (right == null || subRoot == null || right.`val` != subRoot.`val`) {
            return false
        }
        return check(right.left, subRoot.left) && check(right.right, subRoot.right)
    }
}

class MethodVersion2 :  A572Solution{

    private val r: MutableList<Int?> = ArrayList()
    private val s: MutableList<Int?> = ArrayList()

    private var maxElement: Int = Int.MIN_VALUE
    private var lNull: Int? = null
    private var rNull: Int? = null

    override fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) {
            return false
        }

        getMaxElement(root)
        getMaxElement(subRoot)

        lNull = maxElement + 1
        rNull = maxElement + 2

        getDfsOrder(root, r)
        getDfsOrder(subRoot, s)


        return kmp()
    }

    private fun getDfsOrder(root: TreeNode?, list: MutableList<Int?>) {
        if (root == null) {
            return
        }
        list.add(root.`val`)
        if (root.left != null) {
            getDfsOrder(root.left, list)
        } else {
            list.add(lNull)
        }

        if (root.right != null) {
            getDfsOrder(root.right, list)
        } else {
            list.add(rNull)
        }
    }

    private fun getMaxElement(root: TreeNode?) {
        if (root == null) {
            return
        }
        maxElement = max(maxElement.toDouble(), root.`val`.toDouble()).roundToInt()
        getMaxElement(root.left)
        getMaxElement(root.right)
    }

    // TODO 背诵 默写模板
    private fun kmp(): Boolean {
        val m = r.size
        val n = s.size
        val fail = IntArray(n)
        Arrays.fill(fail, -1)
        run {
            var i = 1
            var j = -1
            while (i < n) {
                while (j != -1 && s[i] != s[j + 1]) {
                    j = fail[j]
                }
                if (s[i] == s[j + 1]) {
                    j++
                }
                fail[i] = j
                i++
            }
        }

        var i = 0
        var j = -1
        while (i < m) {
            while (j != -1 && r[i] != s[j + 1]) {
                j = fail[j]
            }
            if (r[i] == s[j + 1]) {
                j++
            }
            if (j == n - 1) {
                return true
            }
            i++
        }
        return false
    }
}