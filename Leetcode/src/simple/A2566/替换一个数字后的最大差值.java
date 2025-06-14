package simple.A2566;

public class 替换一个数字后的最大差值 {
    public static void main(String[] args) {
        int i = new 替换一个数字后的最大差值().minMaxDifference(1);
        System.out.println(i);
    }
    public int minMaxDifference(int num) {
        int[] numbers = new int[9] ;
        int right = 0 ;
        while (num != 0){
            numbers[right++] = num % 10;
            num /= 10;
        }
        int max = 0 , min = 0 , maxNum = -1 , minNum = numbers[right - 1]; ;
        while(right != 0){
            right --;
            max *= 10;
            min *= 10;

            int temp = numbers[right];
            if(minNum != temp){
                min += temp;
            }
            if(maxNum == -1 && temp != 9){
                maxNum = temp;
            }
            if(maxNum != temp){
                max += temp;
            }else{
                max += 9;
            }
        }


        return max - min;
    }
}
