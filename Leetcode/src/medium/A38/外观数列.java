package medium.A38;

public class 外观数列 {
    public static void main(String[] args) {
        String s = new 外观数列().countAndSay(4);
        System.out.println(s);
    }


    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        res = countAndSay2(1, n, res);
        return res.toString();
    }
    private StringBuilder countAndSay2(int start , int n ,StringBuilder res){
        if(start > n ){
            return res;
        }
        if(start == 1){
            res.append("1");
        }else{
            StringBuilder temp = new StringBuilder();
            int l = 0;
            for(int i = 0 ; i < res.length() ; i++){
                if(res.charAt(l) == res.charAt(i)) continue;
                else {
                    temp.append(i -l);
                    temp.append(res.charAt(l));
                    l = i ;
                    -- i;
                }
            }
            if(l != res.length()){
                temp.append(res.length() - l);
                temp.append(res.charAt(l));
            }
            res = temp;
        }
        return  countAndSay2(start + 1 , n ,res);
    }
}
