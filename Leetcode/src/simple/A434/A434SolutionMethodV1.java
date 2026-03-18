package simple.A434;

public class A434SolutionMethodV1 implements A434Solution{
    @Override
    public int countSegments(String s) {
        int res = 0;
        char pre = ' ';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ' && pre != ' ') {
                res ++;
            }
            pre = cur;
        }
        if(pre != ' ') {
            res ++;
        }
        return res;
    }
}
