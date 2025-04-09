package medium.A49;

import java.util.*;

public class 字母异位词分组 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = new 字母异位词分组().groupAnagrams(strs);
        System.out.println((byte)'a');
        lists.forEach(list -> System.out.println(list));
        strs = new String[10000];
        for(int i = 0; i < 10000; i++) {
            // 每个字符串长度为100最大值
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < 100 ; j++) {
                char ch  = (char) (new Random().nextInt(26) + 97);
                temp.append(ch);
            }
            strs[i] = temp.toString();
        }
        for (String str : strs) {
            System.out.printf("\"");
            System.out.printf(str);
            System.out.printf("\",");
        }

        lists = new 字母异位词分组().groupAnagrams(strs);
        lists.forEach(list -> System.out.println(list));


    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return  new ArrayList<>(map.values());
    }
}
