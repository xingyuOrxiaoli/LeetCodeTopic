package simple.A217;

import java.util.HashSet;

public class 存在重复元素 {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(visited.contains(nums[i])) return true;
            visited.add(nums[i]);
        }
        return false;
    }
}
