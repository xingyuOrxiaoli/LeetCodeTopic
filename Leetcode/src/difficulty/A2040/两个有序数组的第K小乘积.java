package difficulty.A2040;

public class 两个有序数组的第K小乘积 {
    public static void main(String[] args) {

    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {

        int n = nums1.length;
        long left = -10000000000L , right = 10000000000L;
        while (left <= right) {
            long mid = left + (right - left) / 2 , count = 0;

            for(int i = 0 ; i < n ; i++) {
                count += search(nums2 , nums1[i], mid);
            }
            if(count < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    private long search(int[] nums2, int x, long cur) {
        int left = 0 , right = nums2.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2 ;
            long value = (long)nums2[mid] * x;
            if((x >= 0 && value <= cur) || (x < 0 && value > cur)){
                left = mid + 1;
            }else right = mid - 1;
        }

        if(x >= 0) return left;
        return nums2.length - left;
    }
}
