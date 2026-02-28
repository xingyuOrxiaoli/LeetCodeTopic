package difficulty.A2612;

import java.util.*;

/**
 * BFS模拟解法
 *
 * 寻找P节点到其它节点的最短路径
 */
public class A2612SolutionBFS implements A2612Solution {
    @Override
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        Set<Integer> bannedSet = new HashSet<>();
        Arrays.stream(banned).forEach(bannedSet::add);

        TreeSet<Integer>[] indices = new TreeSet[]{new TreeSet<>(), new TreeSet<>()};

        for (int i = 0; i < n; i++) {
            if (i != p && !bannedSet.contains(i)) {
                indices[i % 2].add(i);
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        // 起点
        res[p] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int l = Math.max(cur - k + 1, k - cur - 1);
            int r = Math.min(cur + k - 1, n * 2 - k - 1 - cur);

            // A2612SolutionBFSUnion进行优化
            // 1. treeSet的维护，使用列表，之后
            // 2. 提供每一个元素的next元素，这减少遍历删除元素
            for (Iterator<Integer> iterator = indices[l % 2].tailSet(l).headSet(r + 2).iterator(); iterator.hasNext(); iterator.remove()) {
                int j = iterator.next();
                res[j] = res[cur] + 1;
                queue.offer(j);
            }
        }
        return res;
    }
}
