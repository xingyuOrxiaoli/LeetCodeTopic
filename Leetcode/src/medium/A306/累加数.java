package medium.A306;

public class 累加数 {

    public boolean isAdditiveNumber(String num) {
        int  n = num.length() ;
        // if(num.charAt(0) == '0') return false;

        for(int i = 1 ; i < n ; i++){
            // if(num.charAt(i) == '0') continue;
            for(int j = i ; j < n ; j ++){
                if(isCheck(i , j , num)) return true;
                if(num.charAt(i) == '0') break;
            }
            if(num.charAt(0) == '0') break;
        }

        return false;
    }

    private boolean isCheck(int left, int right, String num) {
        if(right == num.length() - 1) return false;
        int first  = 0 , second = 0 ;
        // 初始化
        for(int i  = 0 ; i < left ; i ++) first = first *  10 + num.charAt(i) - '0';
        for(int i = left ; i <= right ; i ++) second  = second *  10 + num.charAt(i) - '0';

        int next = second + first , index = right + 1 , t = 0;
        while(index < num.length()){
            char ch = num.charAt(index);
            if(ch == '0' && t  == 0 && next != 0) return false;
            t = t * 10 + num.charAt(index) - '0';
            if(next == t){
                t = 0 ;
                first = second;
                second = next;
                next = first + second;
            }
            index ++;
        }
        if(t == 0) return true;
        return false;
    }

}
