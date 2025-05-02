package medium.A838;

public class 推多米诺 {
    public static void main(String[] args) {
        String s = new 推多米诺().pushDominoes(".L.R....LR..L..");
        System.out.println(s);
    }
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] left = new char[n] , right = new char[n] , ch = dominoes.toCharArray();
        left[n - 1] = ch[n - 1];
        right[0] = ch[0];
        // 左边
        for(int j = n - 2 ; j > -1 ; j--){
            if(left[j + 1] == '.' || left[j + 1] == 'R' || ch[j] == 'R') left[j] = ch[j];
            else left[j] = left[j + 1];
        }
        // 右边
        for(int i = 1 ; i < n ; i++){
            if(right[i - 1] == '.' || right[i - 1] == 'L' || ch[i] == 'L') right[i] = ch[i];
            else right[i] = right[i - 1];
        }
        StringBuilder res = new StringBuilder();
        int i = 0 , j = 0 ;
        while(i < n){

            if(left[i] == '.' || right[i] == '.') {
                res.append(left[i] != '.' ? left[i] : right[i]);
                i ++;
            }
            else if(left[i] ==right[i]){
                res.append(left[i]);
                i++;
            }else{
                j = i ;
                while(left[j] != right[j]) j ++;
                int temp = j - i ;
                for(int k = i ; k < j ; k ++){
                    if(k - i+ 1 <= (temp >> 1)) res.append(right[k]);
                    else if((k - i + 1) == (temp >> 1) + 1 &&(temp & 1) == 1) res.append('.');
                    else res.append(left[k]);
                }
                i = j;
            }
        }


        return res.toString();
    }
}
