package simple.A3304;

public class 找出第K个字符I {
    public static void main(String[] args) {
        char c = new 找出第K个字符I().kthCharacter(5);
        System.out.println(c);
    }
    public char kthCharacter(int k) {
        StringBuilder res = new StringBuilder();
        res.append('a');
        while(k > res.length()){
            String str = res.toString();
            for (char ch : str.toCharArray()) {
                if(ch == 'z') res.append('a');
                else res.append((char)(ch + 1));
            }
        }
        return res.charAt(k - 1);
    }


}
