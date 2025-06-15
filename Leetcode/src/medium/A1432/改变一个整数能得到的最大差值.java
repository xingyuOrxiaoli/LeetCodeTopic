package medium.A1432;

public class 改变一个整数能得到的最大差值 {
    public static void main(String[] args) {
        int i = new 改变一个整数能得到的最大差值().maxDiff(9288);
        System.out.println(i);
    }
    public int maxDiff(int num) {
        int[] numbers = new int[9] , kinds = new int[10];
        int max = 0 , min = 0 , kind = 0 , maxNumber = -1 , minNumber = -1 , index = 0 , firstNumber = 0;
        boolean isFirst = true;

        while(num != 0){
            numbers[index] = num % 10;
            kinds[numbers[index]]++;
            if(numbers[index] != 0 && kinds[numbers[index]] == 1) kind ++;
            num /= 10;
            index ++;
        }
        while (index != 0){
            index --;
            max *= 10;
            min *= 10;

            // 最大值
            if(maxNumber == -1 && numbers[index] != 9) maxNumber = numbers[index];
            if(maxNumber == numbers[index]) max += 9;
            else max += numbers[index];

            // 最小值
            if(kind > 1) {
                if (firstNumber == 0) {
                    firstNumber = numbers[index];
                }
                if(firstNumber > 1 && minNumber == -1) minNumber = numbers[index];
                else if(minNumber == -1 && firstNumber != numbers[index] && numbers[index] != 0) minNumber = numbers[index];
                if(minNumber == firstNumber && minNumber == numbers[index]) min += 1;
                else if(minNumber != firstNumber && minNumber == numbers[index]) min += 0;
                else min += numbers[index];

            }else min += Math.min(1 , numbers[index]);
        }

        return max - min;
    }
}
