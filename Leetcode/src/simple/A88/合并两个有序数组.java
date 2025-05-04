package simple.A88;

public class 合并两个有序数组 {


    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        new 合并两个有序数组().merge(nums1,1,nums2,1);
    }
    // 暴力解
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int i = 0 , j = 0 , left = 0 , right = m + n , len = m;
        while(left < right){
            if(j >= n) break;
            if(i != m &&nums1[left] <= nums2[j] ) i++;
            else{
                for(int k = len;  k > left ; k --) nums1[k] = nums1[k - 1];
                len ++ ;
                nums1[left] = nums2[j ++ ];
            }
            left ++;
        }
    }


}
