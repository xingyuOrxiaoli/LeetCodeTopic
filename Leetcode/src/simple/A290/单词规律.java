package simple.A290;

import java.util.HashMap;

public class 单词规律 {
    public static void main(String[] args) {
        boolean b = new 单词规律().wordPattern("abba", "dog dog dog dog");
        System.out.println(b);
    }
    public boolean wordPattern(String pattern, String s) {
        HashMap<String,Character> map = new HashMap<>();

        String[] split = s.split(" ");
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < split.length; i++) {
            char value = pattern.charAt(i);
            String key = split[i];
            if(!map.containsValue(value) && !map.containsKey(key)) map.put(key,value);
            else if(!map.containsKey(key) || !map.get(key).equals(value)) return false;
        }
        return true;
    }
}
