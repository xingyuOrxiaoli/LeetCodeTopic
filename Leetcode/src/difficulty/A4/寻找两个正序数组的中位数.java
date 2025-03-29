package difficulty.A4;

public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double medianSortedArrays = new 寻找两个正序数组的中位数().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid = (length1 + length2) >> 1;
        int flag = (length1 + length2) & 1; // 1 奇 mid+1   0 偶 mid  mid+1
        int index1 = 0;
        int index2 = 0;
        while(true){
            if(index1 == length1){
                res = nums2[index2 + mid];
                if(flag == 0) res += nums2[index2 + mid -1];
                break;
            }

            if(index2 == length2){
                res = nums1[index1 + mid];
                if(flag == 0) res += nums1[index1 + mid -1];
                break;
            }
            if(mid == 1){
                if(nums1[index1] > nums2[index2])
                    if(index2 != length2 -1 ) res =Math.min(nums2[index2 + 1],nums1[index1]);
                    else res = nums1[index1];
                else
                if(index1 != length1 -1) res = Math.min(nums1[index1 + 1],nums2[index2]);
                else res = nums2[index2];
                if(flag == 0) res += Math.min(nums1[index1],nums2[index2]);
                break;
            }
            int temp = mid >> 1;
            int tempIndex1 = Math.min(temp + index1 , length1) -1;
            int tempIndex2 = Math.min(temp + index2 , length2) -1;
            int num1 = nums1[tempIndex1] , num2 = nums2[tempIndex2];
            if(num1 > num2){
                mid -= (tempIndex2 -index2 + 1);
                index2 = tempIndex2 +1;
            }else{
                mid -= (tempIndex1 - index1 + 1);
                index1 = tempIndex1 +1;
            }

        }
        if (flag == 0) res /= 2.0;
        return res;
    }
}
