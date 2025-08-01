package simple.A面试题01_03;

public class URL化 {
    public String replaceSpaces(String S, int length) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') res.append("%20");
            else res.append(S.charAt(i));
        }

        return res.toString();
    }
}
