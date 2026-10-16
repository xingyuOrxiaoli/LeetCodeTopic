package utils;
import java.util.Arrays;

/**
 * 无区间更新
 */
public class SegmentTree {

    private final int n;

    private final long[] tree;

    /**
     * 线段树维护一个长为 n 的数组（下标从 0 到 n-1），元素初始值为 initVal
     * @param n
     * @param initVal
     */
    public SegmentTree(int n, long initVal) {
        this.n = n;
        long[] a = new long[n];
        Arrays.fill(a,initVal);
        tree = new long[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        build(a, 1 , 0 , n - 1);
    }

    /**
     * 线段树维护数组a
     * @param a
     */
    public SegmentTree(long[] a) {
        n = a.length;
        tree = new long[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        build(a, 1, 0, n - 1);
    }

    /**
     * a 初始化线段树
     * 时间复杂度O(n)
     */
    private void build(long[] a, int node, int l, int r) {
        if (l == r) {
            // 叶子节点
            tree[node] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        // 初始化左右子树
        build(a,node * 2 , l , mid);
        build(a,node * 2 + 1 , mid + 1 , r);
        maintain(node);
    }

    /**
     * 合并左右儿子的val到当前节点的val
     * @param node
     */
    private void maintain(int node) {
        tree[node] = mergeVal(tree[node * 2], tree[node * 2 + 1]);
    }

    private long mergeVal(long a, long b) {
        return a + b;
    }

    /**
     * ==========更新操作 ======================
     */
    public void update(int i, long val) {
        update(1,0, n - 1, i , val);
    }
    private void update(int node , int l , int r , int i ,long val) {
        if (l == r) {
            // 叶子节点
            tree[node] = mergeVal(tree[node],val);
            return;
        }
        int mid = (l + r) / 2;
        if (i <= mid) {
            update(node * 2 , l , mid , i , val);
        } else {
            update(node * 2 + 1 , mid + 1 , r , i ,val);
        }
        maintain(node);
    }
    public long query(int ql , int qr) {
        return query(1, 0,n-1, ql , qr);
    }

    /**
     * log(n)查询
     */
    private long query(int node , int l , int r, int ql , int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        if (ql <= mid) {
            return query(node * 2 , l , mid , ql , qr);
        }
        if (ql > mid) {
            return query(node * 2 + 1 , mid + 1 , r , ql , qr);
        }
        // [ql , qr] 与左右子树都有交集，分别递归，之后进行合并结果
        long left = query(node * 2 , l , mid , ql , qr);
        long right = query(node * 2 + 1 , mid + 1 , r , ql , qr);
        return mergeVal(left, right);
    }

    // 获取a[i]的值
    public long get(int i) {
        return query(1, 0 , n - 1 , i , i);
    }

}
