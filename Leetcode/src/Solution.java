import java.util.Arrays;

// 模板来源 https://leetcode.cn/discuss/post/3583665/
// 线段树有两个下标，一个是线段树节点的下标，另一个是线段树维护的区间的下标
// 节点的下标：从 1 开始，如果你想改成从 0 开始，需要把左右儿子下标分别改成 node*2+1 和 node*2+2
// 区间的下标：从 0 开始
class SegmentTree1 {
    private final int n;
    private final long[] tree; // 如果计算结果没有超出 int 范围，可以改成 int

    // 合并两个 val
    private long mergeVal(long a, long b) {
        return Math.max(a, b); // **根据题目修改**
    }

    // 线段树维护一个长为 n 的数组（下标从 0 到 n-1），元素初始值为 initVal
    public SegmentTree1(int n, long initVal) {
        this.n = n;
        long[] a = new long[n];
        Arrays.fill(a, initVal);
        tree = new long[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        build(a, 1, 0, n - 1);
    }

    // 线段树维护数组 a
    public SegmentTree1(long[] a) {
        n = a.length;
        tree = new long[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        build(a, 1, 0, n - 1);
    }

    // 更新 a[i] 为 mergeVal(a[i], val)
    // 时间复杂度 O(log n)
    public void update(int i, long val) {
        update(1, 0, n - 1, i, val);
    }

    // 合并左右儿子的 val 到当前节点的 val
    private void maintain(int node) {
        tree[node] = mergeVal(tree[node * 2], tree[node * 2 + 1]);
    }

    // 用 a 初始化线段树
    // 时间复杂度 O(n)
    private void build(long[] a, int node, int l, int r) {
        if (l == r) { // 叶子
            tree[node] = a[l]; // 初始化叶节点的值
            return;
        }
        int m = (l + r) >>> 1;
        build(a, node * 2, l, m); // 初始化左子树
        build(a, node * 2 + 1, m + 1, r); // 初始化右子树
        maintain(node);
    }

    private void update(int node, int l, int r, int i, long val) {
        if (l == r) { // 叶子（到达目标）
            // 如果想直接替换的话，可以写 tree[node] = val
            tree[node] = mergeVal(tree[node], val);
            return;
        }
        int m = (l + r) >>> 1;
        if (i <= m) { // i 在左子树
            update(node * 2, l, m, i, val);
        } else { // i 在右子树
            update(node * 2 + 1, m + 1, r, i, val);
        }
        maintain(node);
    }

    // 返回用 mergeVal 合并所有 a[i] 的计算结果，其中 i 在闭区间 [ql, qr] 中
    // 时间复杂度 O(log n)
    public long query(int ql, int qr) {
        return query(1, 0, n - 1, ql, qr);
    }

    private long query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) { // 当前子树完全在 [ql, qr] 内
            return tree[node];
        }
        int m = (l + r) >>> 1;
        if (qr <= m) { // [ql, qr] 与右子树无交集，仅需递归左子树
            return query(node * 2, l, m, ql, qr);
        }
        if (ql > m) { // [ql, qr] 与左子树无交集，仅需递归右子树
            return query(node * 2 + 1, m + 1, r, ql, qr);
        }
        // [ql, qr] 与左右子树均有交集，分别递归，然后合并结果
        long lRes = query(node * 2, l, m, ql, qr);
        long rRes = query(node * 2 + 1, m + 1, r, ql, qr);
        return mergeVal(lRes, rRes);
    }

    // 获取 a[i] 的值
    // 时间复杂度 O(log n)
    public long get(int i) {
        return query(1, 0, n - 1, i, i);
    }
}