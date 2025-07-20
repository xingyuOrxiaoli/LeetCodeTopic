import java.util.*;

public class Solution {

    public int countTrapezoids(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;

        Map<String, Map<Long, Set<Integer>>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1, dy = y2 - y1;

                int t = gcd(Math.abs(dx), Math.abs(dy));
                if (t != 0) {
                    dx /= t;
                    dy /= t;
                }

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                long s = (long) dy * x1 - (long) dx * y1;
                String key = dx + "_" + dy;

                Map<Long, Set<Integer>> t_map = map.computeIfAbsent(key, k -> new HashMap<>());
                Set<Integer> set = t_map.computeIfAbsent(s, k -> new HashSet<>());
                set.add(i);
                set.add(j);
            }
        }

        long res = 0;
        for (Map<Long, Set<Integer>> inner : map.values()) {
            long sum1 = 0,  sum2 = 0;
            for (Set<Integer> set : inner.values()) {
                int m = set.size();
                if (m < 2) continue;
                long t = comb2(m);
                sum1 += t;
                sum2 += t * t;
            }
            res += (sum1 * sum1 - sum2) / 2;
        }

        Map<String, List<int[]>> count_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                String key = (x1 + x2) + "_" + (y1 + y2);
                count_map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        long t = 0;
        for (List<int[]> list : count_map.values()) {
            int k = list.size();
            if (k < 2) continue;
            long count = comb2(k);
            Map<Integer, Integer> t_map = new HashMap<>();
            for (int[] value : list) {
                t_map.put(value[0], t_map.getOrDefault(value[0], 0) + 1);
                t_map.put(value[1], t_map.getOrDefault(value[1], 0) + 1);
            }

            long count2 = 0;
            for (int value : t_map.values()) {
                if (value >= 2) {
                    count2 += comb2(value);
                }
            }

            t += (count - count2);
        }

        return (int) (res - t);
    }

    private long comb2(int x) {
        return x < 2 ? 0 : (long) x * (x - 1) / 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}