package simple.A1323;

public class A6和9组成的最大数字 {

    public int maximum69Number (int num) {
        int add = 0 , cur = 1;
        while(cur < num){
            int temp = (num / cur) % 10;
            if(temp == 6) add = 3 * cur;
            cur *= 10;
        }

        return num + add;
    }
}
