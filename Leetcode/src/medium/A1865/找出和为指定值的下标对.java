package medium.A1865;

import java.util.HashMap;

public class 找出和为指定值的下标对 {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});

        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3,2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0,1);
        findSumPairs.add(1,1);
        System.out.println(findSumPairs.count(7));

    }
}



class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private HashMap<Integer, Integer> map = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2) map.put(num,map.getOrDefault(num ,0 ) + 1);
    }

    public void add(int index, int val) {
        int key = nums2[index];
        map.put(key,map.get(key) - 1);

        nums2[index] += val;
        key = nums2[index];
        map.put(key,map.getOrDefault(key,0) + 1);
    }

    public int count(int tot) {
        int res = 0 ;
        for (int num : nums1) {
            res += map.getOrDefault(tot - num, 0 );
        }
        return res;
    }
}