package simple.A3340;

public class 检查平衡字符串 {
    public static void main(String[] args) {
        boolean balanced = new 检查平衡字符串().isBalanced("1234");
        System.out.println(balanced);
    }
    public boolean isBalanced(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        int n = num.length();
        boolean res = false;
        int bal = 0;
        for(int i = 0 ;i < n ; i+=2){
            bal += num.charAt(i);
            if(i + 1 < n) bal -= num.charAt(i+1);
        }
        System.out.println(bal);
        if(bal == 0 || bal == 48) res = true;
        return res;
    }
}
