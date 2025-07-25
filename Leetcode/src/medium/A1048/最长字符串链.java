package medium.A1048;

import java.util.*;

public class 最长字符串链 {

    public static void main(String[] args) {
        int i = new 最长字符串链().longestStrChain(new String[]{"a","ab","ac","bd","abc","abd","abdd"});
        System.out.println(i);
    }

    public int longestStrChain(String[] words) {
        int n = words.length , res = 1 ;
        HashMap<String ,List<String>> map = new HashMap<>();
        HashSet<String> isParent = new HashSet<>();
        for(int i = 0 ; i <  n ; i ++){
            for(int j = i + 1 ; j < n ; j ++){
                String a = words[i] , b = words[j];
                if(isCheck(a , b)){
                    if(a.length() > b.length()){
                        map.putIfAbsent(b, new ArrayList());
                        map.get(b).add(a);
                        isParent.add(a);
                    }else{
                        map.putIfAbsent(a, new ArrayList());
                        map.get(a).add(b);
                        isParent.add(b);
                    }
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        for(String key : map.keySet()){
            if(!isParent.contains(key)){
                queue.offer(key);
                levels.offer(1);
            }
        }
        HashMap<String,Integer> visited = new HashMap();
        while(!queue.isEmpty()){
            String curKey = queue.poll();
            Integer level = levels.poll();
            if(visited.containsKey(curKey) &&  visited.get(curKey) >= level) continue;
            visited.put(curKey, level);
            for(String key : map.get(curKey)){
                if(map.get(key) != null){
                    queue.offer(key);
                    levels.offer(level + 1);
                }
                res = Math.max(res , level + 1);
            }
        }
        return res ;
    }
    private boolean isCheck(String a , String b){
        int a_n = a.length() , b_n = b.length();
        if(a_n == b_n || Math.abs(b_n - a_n) != 1) return false;
        if(a_n > b_n) return isCheck(b , a);
        boolean flag = false;
        for(int i = 0 , j = 0 ; i < b_n ; i ++ , j ++){
            if(j == a_n) return true;
            if(a.charAt(j) == b.charAt(i)) continue;
            if(flag) return false;
            flag = true;
            j --;
        }
        return true;
    }
}
