import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Main{

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            while (T -- > 0) {
                String s = br.readLine();
                String[] split = s.split(" ");
                int n = Integer.parseInt(split[0]);
                int m = Integer.parseInt(split[1]);
                int p = Integer.parseInt(split[2]);
                int[] numsA = new int[n];
                s = br.readLine();
                split = s.split(" ");
                for (int i = 0; i < n; i++) {
                    numsA[i] = Integer.parseInt(split[i]);
                }
                int[] numsB = new int[m];
                s = br.readLine();
                split = s.split(" ");
                for (int i = 0; i < m; i++) {
                    numsB[i] = Integer.parseInt(split[i]);
                }
                s = br.readLine();
                char[] ops = s.toCharArray();
                int[] res = noGainCount(n , m , p , numsA,numsB,ops);
                for (int i = 0; i < p - 1; i++) {
                    System.out.printf(res[i] + " ");
                }
                System.out.println(res[p - 1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static int[] noGainCount(int n, int m, int p, int[] numsA, int[] numsB, char[] ops) {
        int[] res = new int[p];
        TreeSet<Integer> set = new TreeSet<>();
        for (int b : numsB) {
            set.add(b);
        }
        boolean[] exist = new boolean[n];
        Arrays.fill(exist,false);
        int cnt = n;
        for (int i = 0; i < n; i++) {
            if (set.contains(numsA[i])) {
                System.out.println(i);
                exist[i] = true;
                cnt --;
            }
        }

        for (int i = 0; i < p; i++) {
            int step = (ops[i] == 'R')? 1 : -1;
            for (int j = 0; j < n; j++) {
                numsA[j] += step;
                if(!exist[j]) {
                    if(set.contains(numsA[j])) {
                        cnt --;
                        exist[j] = true;
                    }
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}

/**
 *
 * 800 -> 1000
 *
 */

class A{
    public void method1(){}
}
class B {
    private A a = new A();

    public void method2(){
        method1_1();
    }
    public void method3(){
        method1_1();}

    public void method4(){
        method1_1();
    }

    private void method1_1(){
        a.method1();
    }

}