package medium.A2109;

public class 向字符串添加空格 {
    public static void main(String[] args) {
        int[] spaces = new int[]{8,13,15};
        String s = new 向字符串添加空格().addSpaces("LeetcodeHelpsMeLearn",spaces);
        System.out.println(s);
    }
    public String addSpaces(String s, int[] spaces) {
        int length = s.length();
        int n = spaces.length;
        StringBuilder res = new StringBuilder(length + n);
        int j = 0;
        for(int i = 0; i < n; i++) {
            String str = s.substring(j, spaces[i]);
            res.append(s.substring(j, spaces[i]));
            res.append(" ");
            j = spaces[i];
        }
        res.append(s.substring(j, length));
        return res.toString();
    }
}
