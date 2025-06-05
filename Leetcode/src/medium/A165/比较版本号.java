package medium.A165;

import java.util.Arrays;

public class 比较版本号 {
    public static void main(String[] args) {
        int i = new 比较版本号().compareVersion("1.2", "1.10");
        String[] split = "1.2".split(".");
        System.out.println(Arrays.toString(split));
        System.out.println(i);
    }
    public int compareVersion(String version1, String version2) {
        int res =  0;
        String[] sp1 = version1.split("\\.") , sp2 = version2.split("\\.") ;
        int n = sp1.length, m = sp2.length;
        int index = 0 ;
        while (index < n && index < m){
            Integer v1 = Integer.parseInt(sp1[index]) , v2 = Integer.parseInt(sp2[index]);
            if(!v1.equals(v2)) return v1.compareTo(v2);
            index ++;
        }
        // 去除前置0
        if(n > m) res = 1;
        if(n < m) {
            res = -1;
            sp1 = sp2;
        }
        while(index < n || index < m){
            Integer v = Integer.parseInt(sp1[index]);
            if(!v.equals(0)) return res;
            index ++;
        }
        return 0;
    }
}
