package medium.A11;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = new 盛最多水的容器().maxArea(height);
        System.out.println(i);
    }
    public int maxArea(int[] height) {
        int res = 0 ;
        int length = height.length;
        // 暴力接
        // for(int i = 0 ; i < length ; i++){
        //     for(int j = 0 ; j < i ; j++){
        //         res = Math.max(res,(i - j ) * Math.min(height[i],height[j]));
        //     }
        // }

        // 因为从 i = 0 j  = length -1靠近 中这个矩阵的一条边再不断减少，因此靠近的过程中左右两条边谁最小谁移动
        int i = 0 ,j = length -1;
        while(i <=  j){
            int left = height[i];
            int right = height[j];
            if(left > right){
                res = Math.max(res, (j - i ) * right);
                do j -- ; while(j > 0 && right >= height[j]);
            } else{
                res = Math.max(res,(j - i ) * left);
                do i ++ ; while(i < length && left >= height[i]);
            }
        }
        return res;
    }
}
