package difficulty.A65;

public class 有效数字 {
    public static void main(String[] args) {
        boolean number = new 有效数字().isNumber("+6e-1");
        System.out.println(number);
    }
    public boolean isNumber(String s) {
        if("Infinity".equals(s) || "-Infinity".equals(s)|| "+Infinity".equals(s)) return false;
        char ch = s.charAt(s.length()-1);
        if( ch != '.' &&  (ch < '0' || ch > '9' )) return false;
        try {
            Double v = Double.valueOf(s);
            System.out.println(v);
        }catch (NumberFormatException e){
            return false;
        }
       return true;
    }
}
