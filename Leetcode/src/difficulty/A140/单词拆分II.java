package difficulty.A140;


import java.util.*;

public class 单词拆分II {
    public static void main(String[] args) {

    }



    // 方法 1 TODO  参考LeetCode题解
    public List<String> wordBreak1(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> list = dfs(s,s.length(),0,map,new HashSet<>(wordDict));
        List<String> res = new LinkedList<>();
        list.forEach(value -> res.add(String.join(" ", value)));
        return res;
    }

    private List<List<String>> dfs(String s, int length, Integer index, Map<Integer,List<List<String>>> map, HashSet<String> dict) {
        if(!map.containsKey(index)){
            List<List<String>> temp = new LinkedList<>();
            if(index == length) temp.add(new LinkedList<>());
            for(int i = index + 1 ; i <= length ; i++){
                String word = s.substring(index, i);
                if(dict.contains(word)){
                    List<List<String>> next = dfs(s , length,i,map,dict);
                    next.forEach(value -> {
                        LinkedList<String> nextTemp = new LinkedList<String>(value);
                        nextTemp.addFirst(word);
                        temp.add(nextTemp);
                    });

                }
            }
            map.put(index, temp);
        }
        return map.get(index);
    }


    // 方法2 dfs

    public List<String> wordBreak(String s, List<String> wordDict) {
        StringBuilder temp = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(0,s,wordDict,temp,res);
        return res;
    }

    private void dfs(int index, String s, List<String> wordDict, StringBuilder temp, List<String> res) {
        if(index == s.length()){
            res.add(temp.toString());
            return;
        }
        int tempLen = temp.length();
//        for (String word : wordDict) {
//            int len = word.length() ;
//            if(len + index > s.length()) continue;
//            String next = s.substring(index, index + len);
//            if(next.equals(word)){
//                if(!temp.isEmpty()){
//                    temp.append(' ');
//                }
//                temp.append(word);
//                dfs(index + len,s,wordDict,temp,res);
//                temp.setLength(tempLen);
//            }
//        }
        wordDict.forEach(word->{
            int len = word.length() ;
            if(len + index <= s.length()){
                String next = s.substring(index, index + len);
                if(next.equals(word)){
                    if(temp.length() != 0){
                        temp.append(" ");
                    }
                    temp.append(word);
                    dfs(index + len,s,wordDict,temp,res);
                    temp.setLength(tempLen);
                }
            }
        });
    }

}
class Solution {
    /*
     * 思路：
     *   递归选项是 wordDict
     *       对于 word : wordDict
     *       计算wordLen, 若 wordLen + start < len(s)， 则这个单词可选, start 跳过 wordLen 长度
     *   使用 StringBuilder 来追踪, sb 可以直接 setLen() 来复位
     *       注意单词的添加方式，
     *   递归结束是当 start == len(s), 此时 res << sb.toString()
     *
     * 优化：
     *   这个解法不需要生成 wordSet, 并且操作生成最终的字符串上稍有优势
     *  */
    public List<String> wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        wordBreak(0, s, wordDict, sb, res);
        return res;
    }

    private void wordBreak(int start, String s, List<String> wordDict, StringBuilder sb, List<String> res) {
        if (start == s.length()) {
            res.add(sb.toString());
            return;
        }

        int prevBuildLen = sb.length();
        for (String word : wordDict) {
            int wordLen = word.length();
            if (start + wordLen > s.length()) {
                continue;
            }
            String sub = s.substring(start, start + wordLen);
            if (word.equals(sub)) {
                if (sb.length() != 0) {}
//                if (!sb.isEmpty()) {
                    sb.append(' ');
                }
                sb.append(word);
                wordBreak(start + wordLen, s, wordDict, sb, res);
                sb.setLength(prevBuildLen);
            }
        }
    }