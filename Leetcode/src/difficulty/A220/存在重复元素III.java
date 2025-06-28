package difficulty.A220;

import java.util.TreeSet;

public class 存在重复元素III {
    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long)nums[i] + (long)t) return true;
            if(set.size() == k) set.remove((long)nums[i - k]);
            set.add((long) (nums[i]));
        }
        return false;
    }
}
