package medium.A面试题_01_05;

public class 一次编辑 {
    public boolean oneEditAway(String first, String second) {
        int n = first.length() , m = second.length();
        if(Math.abs(n-m) > 1 ) return false;
        if(n < m) return oneEditAway(second , first);
        if(n == 1) return true;
        // 替换或 不需要编辑
        if(n == m){
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(first.charAt(i) != second.charAt(i)) count ++;
                if(count == 2) return false;
            }
        }else{
            // 插入
            int count = 0;
            for(int i = 0 , j = 0 ; i < n && j < m ; i++ , j ++){
                if(first.charAt(i) != second.charAt(j)) {
                    count++;
                    j --;
                }
                if(count == 2) return false;
            }
        }
        return true;
    }
}
