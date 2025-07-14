package medium.A307;

public class 区域和检索_数组可修改 {
    public static void main(String[] args) {

    }
}
class NumArray {

    private int[] nums ;
    private int[] tree ;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n  = nums.length;
        tree = new int[n << 2];
        build(0 , 0 , n - 1);
    }

    private void build(int nodeIndex, int left, int right) {
        if(left == right){
            tree[nodeIndex] = nums[left];
            return;
        }
        int mid = left + ((right - left )>> 1);
        // 左 2n + 1
        build((nodeIndex << 1) + 1 , left, mid);
        // 右 2n + 2
        build((nodeIndex << 1) + 2 , mid + 1, right);
        tree[nodeIndex] = tree[(nodeIndex << 1) + 1] + tree[(nodeIndex << 1) + 2];
    }

    public void update(int index, int val) {
        update(0,0 , nums.length - 1 , index , val);
    }

    private void update(int nodeIndex , int left, int right, int index, int val) {
        if(left == right){
            tree[nodeIndex] = val;
            return;
        }
        int mid = left + ((right - left )>> 1);

        if (index <= mid) {
            update((nodeIndex << 1) + 1, left, mid, index, val);
        } else {
            update((nodeIndex << 1) + 2, mid + 1, right, index, val);
        }

        tree[nodeIndex] = tree[2 * nodeIndex + 1] + tree[2 * nodeIndex + 2];
    }

    public int sumRange(int left, int right) {
        return query(0 , 0 , nums.length - 1 , left , right);
    }

    private int query(int nodeIndex, int left, int right, int queryLeft, int queryRight) {
        if(queryRight < left || queryLeft > right) return 0;
        if(queryRight >= right && queryLeft <= left) return tree[nodeIndex];

        int mid = left + ((right - left )>> 1);

        return query((nodeIndex << 1) + 1 , left, mid, queryLeft, queryRight) + query((nodeIndex << 1) + 2 , mid + 1, right, queryLeft, queryRight);

    }
}