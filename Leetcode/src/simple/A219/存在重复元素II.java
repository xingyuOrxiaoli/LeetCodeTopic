package simple.A219;

import java.util.HashMap;

public class 存在重复元素II {
    public static void main(String[] args) {

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if(visited.containsKey(nums[i]) && i - visited.get(nums[i]) <= k) return true;
            visited.put(nums[i], i);
        }

        return false;
    }
}
