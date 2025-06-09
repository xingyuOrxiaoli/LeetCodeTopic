package simple.A202;

import java.util.HashSet;

public class 快乐数 {
    public static void main(String[] args) {
        boolean happy = new 快乐数().isHappy(19);
        System.out.println(happy);
    }
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        while(!visited.contains(n)) {
            visited.add(n);
            int t = 0 ;
            while(n != 0){
                t += (int) Math.pow(n % 10 ,2);
                n /= 10;
            }
            n = t;
            if(n == 1) return true;
        }
        return false;
    }
}
