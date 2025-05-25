package difficulty.A127;

import java.util.*;

public class 单词接龙 {
    public static void main(String[] args) {
        String[] str = {
                "hot","dot","dog","lot","log","cog"
        };
        List<String> wordList = new ArrayList<>(Arrays.asList(str));
        int i = new 单词接龙().ladderLength("hit", "cog", wordList);
        System.out.println(i);
    }
    int[][] edges;
    Map<String,Integer> map = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        edges   =  new int[wordList.size() + 1][wordList.size() + 1];
        boolean[] visited =  new boolean[wordList.size() + 1];
        map.put(beginWord,0);
        for (int i = 0; i < wordList.size(); i++) map.put(wordList.get(i), i + 1);
        init(beginWord , 0);
        map.forEach((k , v) -> init(k , v));

        Map<String,List<String>> paths = new HashMap<>();
        // 图的层序遍历
        Queue<Integer> queue = new LinkedList<>() , levels = new LinkedList<>();

        // 初始化
        for(int i = 1 ; i < edges.length; i ++){
            if(edges[0][i] == 0) continue;
            queue.add(i);
            levels.add(2);

            List<String> temp = new ArrayList<>();
            temp.add(beginWord);
            temp.add(wordList.get(i - 1));

            paths.put(wordList.get(i - 1) + 2,temp);
            if(wordList.get(i - 1).equals(endWord)){
                return 2;
            }
        }
        visited[0] = true;

        while(!queue.isEmpty() ) {
            int cur = queue.poll() , level = levels.poll();
            String key = wordList.get(cur - 1) + level;
            List<String> pre_path = paths.get(key);

            for(int i = 0 ; i < edges.length; i ++){
                if(edges[cur][i] == 0 || visited[i]) continue;

                List<String> next_path = new ArrayList<>(pre_path);
                next_path.add(wordList.get(i - 1));

                if(wordList.get(i - 1).equals(endWord)){
                    return level + 1;
                }else paths.put(wordList.get(i - 1) +(level + 1) ,next_path);
                queue.add(i);
                levels.add(level + 1);
            }
            visited[cur] = true;
        }

        return 0;
    }

    private void init(String beginWord,int x) {
        char[] beginWordCharArray = beginWord.toCharArray();
        for (int i = 0; i < beginWordCharArray.length; i++) {
            char temp = beginWordCharArray[i];
            for(int j = 0 ; j < 26 ; j ++){
                if(j + 'a' == temp) continue;
                beginWordCharArray[i] = (char) (j + 'a');
                String key = String.valueOf(beginWordCharArray);
                if(map.get(key) != null)
                    edges[x][map.get(key)] = 1;
            }
            beginWordCharArray[i] = temp;
        }
    }
}
