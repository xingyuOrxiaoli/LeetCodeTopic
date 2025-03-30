package difficulty.A30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 串联所有单词的子串 {
    public static void main(String[] args) {
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        List<Integer> barfoothefoobarman = new 串联所有单词的子串().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words);
        System.out.println(barfoothefoobarman);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int slength = s.length() , wsize = words.length,wlength = words[0].length();
        int plength = wsize * wlength;
        List<Integer> res = new ArrayList<>();
        if(slength < plength){
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for( int i = 0 ; i < wlength ; i++) {
            if(i + wsize * wlength > slength){
                break;
            }
//            String key = null;
            for (int j = 0; j < wsize; j++) {
                String key = s.substring(i + j * wlength, i + (j + 1) * wlength);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) - 1);
                if (map.get(word) == 0) {
                    map.remove(word);
                }
            }
            for (int k = i; k < slength - wsize * wlength + 1; k += wlength) {
                if (k != i) {
                    String key = s.substring(k + (wsize - 1) * wlength, k + wsize * wlength);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    if (map.get(key) == 0) {
                        map.remove(key);
                    }
                    key = s.substring(k - wlength, k);
                    map.put(key, map.getOrDefault(key, 0) - 1);
                    if (map.get(key) == 0) {
                        map.remove(key);
                    }
                }
                if (map.isEmpty()) {
                    res.add(k);
                }
            }
            map.clear();
        }
        return res;
    }
}
