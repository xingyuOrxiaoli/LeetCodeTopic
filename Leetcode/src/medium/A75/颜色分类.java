package medium.A75;

import java.util.Arrays;

public class 颜色分类 {

    public static void main(String[] args) {
        int[] nums = {
                2,0,2,1,1,0
        };
        new 颜色分类().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int[] dict = new int[3];
        for (int i = 0; i < nums.length; i++) dict[nums[i]]++;
        int index = 0 ;
        for (int i = 0; i < 3; i++)
            while(dict[i] != 0){
                nums[index++] = i;
                dict[i]--;
            }
    }

    // 第二次写
    public void sortColors_2(int[] nums) {
        int[] dic = new int[3] ;
        int index = 0 ;
        for(int i = 0 ; i < nums.length ; i ++) dic[nums[i]] ++;
        for(int i = 0 ; i < nums.length ; i ++){
            if(dic[index] == 0) index ++;
            nums[i] = index;
            dic[index] -- ;
        }
    }
}
