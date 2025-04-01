package medium.A12;

public class 整数转罗马数字 {
    public static void main(String[] args) {
        String s = new 整数转罗马数字().intToRoman(3749);
        System.out.println(s);
    }
    public String intToRoman(int num) {
        char[] ch = new char[]{'I','V','X','L','C','D','M'};
        int [] values = new int[]{1,5,10,50,100,500,1000};
        StringBuilder res = new StringBuilder();

        for(int i = 6 ; i >=0 && num != 0 ; i--){
            char tempch = ch[i];
            int tempvalue = values[i];
            int insert = num / tempvalue;
            if(insert == 0) continue;
            if( insert == 4 ){
                res.append(tempch);
                res.append(ch[i + 1]);
                num -= (values[i+1] - tempvalue);
            }else if((i != 6 && num == 9) || (i != 0 && num / values[i -1] == 9)){
                res.append(ch[i -1]);
                res.append(ch[i + 1]);
                num -=(values[i + 1] - values[i -1]);
            }else{
                for(int j = 0 ; j < insert ; j++){
                    res.append(tempch);
                }
                num %= tempvalue;
            }

        }
        return res.toString();
    }
}
