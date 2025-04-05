package difficulty.A42;

public class 接雨水 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new 接雨水().trap2(height);
        System.out.println(trap);
    }

    // 方法 1
    public int trap(int[] height) {
       int n = height.length;
       if(n < 3 ) return 0;
       int res = 0;
       int[] right = new int[n + 1];
       int[] left  = new int[n + 1];
       left[0] = height[0];
       for(int i  = 1 ; i < n ; i++){
           left[i] = Math.max(left[i - 1], height[i]);
       }
       for(int i = n - 1 ; i >= 0 ; i--){
           right[i] = Math.max(right[i + 1], height[i]);
       }
       for(int i = 1 ; i < n ; i++){
           if(height[i] > right[i + 1] || height[i] > left[i - 1]) continue;
           res +=  Math.min(left[i - 1], right[i + 1]) - height[i];
       }
       return res;
    }

    // 方法二 单调栈  使用数组模拟栈

    public int trap2(int[] height) {
        int n = height.length;
        if(n < 3 ) return 0;
        int size = 0 ;
        int[] stack = new int[n + 10];
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            while(size != 0 && height[i] > height[stack[size]]){
                int temp = stack[size --];
                if(size == 0){
                    break;
                }
                // 理解这一块的乘法，这块的idea
                int left = stack[size];
                int step = i - left - 1;
                res = res + step * (Math.min(height[left] , height[i]) - height[temp]);
            }
            stack[++ size] = i;
        }
        return  res;
    }

    // 方法三 双指针
    public int trap3(int[] height) {
        int n = height.length;
        if(n < 3 ) return 0;
        int res = 0;
        int left = 0,leftMax = 0 ,rightMax = 0 ,right = n - 1;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] > height[right]){
                res += rightMax - height[right];
                right--;
            }else{
                res += leftMax - height[left];
                left++;
            }
        }
        return res;
    }
}
