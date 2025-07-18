package simple.A349;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 两个数组的交集 {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        System.out.println(set);
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
