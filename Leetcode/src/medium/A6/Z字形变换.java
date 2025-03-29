package medium.A6;

public class Z字形变换 {
    public static void main(String[] args) {
        String paypalishiring = new Z字形变换().convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }
    public String convert(String s, int numRows) {
        int length = s.length();
        if(length == 1 || numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int addTo = (numRows << 1) - 2;
        int midAddFirst = 0;
        boolean flag = false;
        for (int i = 0; i < numRows; i++) {
            if(i != 0 && i < numRows - 1) {
                midAddFirst = addTo - (i * 2);
                flag = true;
            }
            for(int j = i ; j < length ; j+= addTo){
                res.append(s.charAt(j));
                if(flag && j + midAddFirst < length) res.append(s.charAt(j + midAddFirst));
            }
            flag = false;
        }
        return res.toString();
    }
}
