package difficulty.A273;

public class 整数转换英文表示 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        String s = new 整数转换英文表示().numberToWords(1000);
        System.out.println(s);
    }
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        String[] singles = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] teens = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] tens = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] thousands = {"","Thousand ", "Million ", "Billion "};
        // 1111 111 11
        // 百  千  百万  十亿
        StringBuilder res = new StringBuilder();
        int index = 0 ;
        while (num != 0) {
            // 1 ~ 999
            int temp1 = num % 10 , temp2 = (num % 100) / 10, temp3 = num % 1000 ;

            if(temp3 != 0 ) {
                res.insert(0, thousands[index]); // 确定单位
                if (temp2 == 0) res.insert(0, singles[temp1]);
                else if (temp2 == 1) res.insert(0, teens[temp1]);
                else res.insert(0, singles[temp1]).insert(0, tens[temp2]);
                temp3 /= 100;
                if (temp3 != 0) {
                    res.insert(0, "Hundred ");
                    res.insert(0, singles[temp3]);
                }
            }
            num /= 1000;
            index ++;
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

}
