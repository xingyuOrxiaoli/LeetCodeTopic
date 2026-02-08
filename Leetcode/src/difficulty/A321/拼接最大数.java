package difficulty.A321;

public class 拼接最大数 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[k];
        int start = Math.max(0, k - m), end = Math.min(k, n);
        for (int i = start; i <= end; i++) {
            int[] first = gainMaxStack(nums1, i), second = gainMaxStack(nums2, k - i);
            int[] t = merge(first, second);
            if (compare(t, 0, res, 0) > 0) System.arraycopy(t, 0, res, 0, k);
        }
        return res;
    }

    private int compare(int[] nums1, int index1, int[] nums2, int index2) {
        int n = nums1.length, m = nums2.length;
        while (index1 < n && index2 < m) {
            if (nums1[index1] != nums2[index2]) return nums1[index1] - nums2[index2];
            index1++;
            index2++;
        }
        return (n - index1) - (m - index2);
    }

    private int[] merge(int[] first, int[] second) {
        int n = first.length, m = second.length, index = 0, index1 = 0, index2 = 0;
        if (n == 0) return second;
        if (m == 0) return first;
        int[] res = new int[n + m];
        while (index1 < n && index2 < m) {
            if (compare(first, index1, second, index2) > 0) res[index++] = first[index1++];
            else res[index++] = second[index2++];
        }
        while (index1 < n) res[index++] = first[index1++];
        while (index2 < m) res[index++] = second[index2++];
        return res;
    }

    private int[] gainMaxStack(int[] nums, int k) {
        int n = nums.length, index = -1, count = n - k;
        int[] res = new int[k];
        for (int num : nums) {
            while (index > -1 && res[index] < num && count > 0) {
                count--;
                index--;
            }
            if (index < k - 1) res[++index] = num;
            else count--;
        }
        return res;
    }
}
