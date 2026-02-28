package difficulty.A2612

import java.util.*
import kotlin.math.max
import kotlin.math.min


fun minReverseOperations(n: Int, p: Int, banned: IntArray, k: Int): IntArray {
    val bannedSet: MutableSet<Int> = banned.toMutableSet()

    val res = IntArray(n)
    val indices = listOf(TreeSet<Int>(), TreeSet<Int>())

    Arrays.fill(res,-1)
    for (i in 0 until n) {
        if (i == p) {
            res[i] = 0
        } else if(!bannedSet.contains(i)) {
            indices[i % 2].add(i)
        }
    }

    val queue: Queue<Int> = java.util.ArrayDeque<Int>()
    queue.offer(p)
    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        val l = max(cur - k + 1, k - 1 - cur)
        val r = min(cur + k - 1, 2 * n - k - 1 - cur)

        indices[l % 2].tailSet(l).headSet(r + 2).removeIf {
            res[it] = res[cur] + 1
            queue.offer(it)
            true
        }
    }

    return res
}

fun main(args: Array<String>) {
    val minReverseOperations = minReverseOperations(5, 0, intArrayOf(2, 4), 3)
    println(minReverseOperations)
}