package difficulty.A3307;

import utils.ArrayUtils;

public class 找出第K个字符I {

    public static void main(String[] args) {
        int[] operations = ArrayUtils.createArrayOne("[1,1,0,1]");
        char c = new 找出第K个字符I().kthCharacter(7, operations);
        System.out.println(c);
    }

    public char kthCharacter(long k, int[] operations) {
        int res = 0 , index = 0 ;
        while(k != 1){
            index =  63 - Long.numberOfLeadingZeros(k);
            if((1 << index) == k){
                index --;
            }
            k -= (1 << index);
            res += operations[index];
        }
        return (char)((res % 26) + 'a');
    }
    public char kthCharacter1(long k, int[] operations) {
        int res = 0 ;
        for(int i = 63 - Long.numberOfLeadingZeros(k --) ; i >= 0 ; i --)
            if((k >> i & 1) == 1) res += operations[i];

        return (char)((res % 26) + 'a');
    }

}
