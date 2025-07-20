package medium.A852;

import utils.ArrayUtils;

public class 山脉数组的峰顶索引 {
    public static void main(String[] args) {
        int i = new 山脉数组的峰顶索引().peakIndexInMountainArray(ArrayUtils.createArrayOne("[3,5,3,2,0]"));

        System.out.println(i);
    }
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0 , right = arr.length - 1 ;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == 0) left = mid + 1;
            else if(mid == arr.length - 1) right = mid - 1;
            else if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if(arr[mid] > arr[mid - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
