package cf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine().trim());
            StringBuilder out = new StringBuilder();
            while (T-- > 0) {
                String[] sp = br.readLine().trim().split(" ");
                int n = Integer.parseInt(sp[0]);
                int m = Integer.parseInt(sp[1]);
                int p = Integer.parseInt(sp[2]);
                int[] numsA = parse(br.readLine(), n);
                int[] numsB = parse(br.readLine(), m);
                char[] ops = br.readLine().trim().toCharArray();
                int[] res = noGainCount(n, p, numsA, numsB, ops);
                for (int i = 0; i < p; i++) {
                    if (i > 0) {
                        out.append(' ');
                    }
                    out.append(res[i]);
                }
                out.append('\n');
            }
            System.out.print(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] parse(String line, int n) {
        String[] sp = line.trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sp[i]);
        }
        return a;
    }

    private static int[] noGainCount(int n, int p, int[] numsA, int[] numsB, char[] ops) {
        TreeSet<Integer> bset = new TreeSet<>();
        for (int b : numsB) {
            bset.add(b);
        }
        int inf = p + 1;
        int off = p;
        int[] first = new int[2 * p + 1];
        Arrays.fill(first, inf);
        int s = 0;
        first[off] = 0;
        for (int t = 1; t <= p; t++) {
            s += ops[t - 1] == 'R' ? 1 : -1;
            int idx = s + off;
            if (first[idx] == inf) {
                first[idx] = t;
            }
        }
        int[] hitAt = new int[p + 1];
        int already = 0;
        for (int a : numsA) {
            int best = inf;
            if (bset.contains(a)) {
                best = 0;
            } else {
                Integer pred = bset.lower(a);
                Integer succ = bset.higher(a);
                if (pred != null) {
                    int idx = pred - a + off;
                    if (idx >= 0 && idx < first.length) {
                        best = Math.min(best, first[idx]);
                    }
                }
                if (succ != null) {
                    int idx = succ - a + off;
                    if (idx >= 0 && idx < first.length) {
                        best = Math.min(best, first[idx]);
                    }
                }
            }
            if (best == 0) {
                already++;
            } else if (best <= p) {
                hitAt[best]++;
            }
        }
        int[] res = new int[p];
        int hit = already;
        for (int i = 1; i <= p; i++) {
            hit += hitAt[i];
            res[i - 1] = n - hit;
        }
        return res;
    }
}
