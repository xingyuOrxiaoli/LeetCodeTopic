package simple.A703;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KthLargest {

    private final List<Integer> list = new ArrayList<>();

    private Integer idx;

    public KthLargest(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            addElement(nums[i]);
        }
        this.idx = k;
    }
    private void addElement(int num) {
        int j = list.size() - 1;
        while (j >= 0 && list.get(j) > num) {
            j --;
        }
        list.add(j + 1, num);
    }
    public int add(int val) {
        addElement(val);
        return list.get(list.size() - idx);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */