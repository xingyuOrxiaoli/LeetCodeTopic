package simple.A168;

public class Excel表列名称 {
    public static void main(String[] args) {
        String s = new Excel表列名称().convertToTitle(1);
        System.out.println(s);
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0 ) {
            columnNumber --;
            int temp = columnNumber % 26;
            res.append((char) (temp + 'A'));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
