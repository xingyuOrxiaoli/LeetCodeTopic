package difficulty.A126;

import java.util.ArrayList;
import java.util.*;

public class 单词接龙II {
    public static void main(String[] args) {
        String[] str = {
                "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
//        str = new String[]{
//                "cog"
//        };
        List<String> wordList = new ArrayList<>(Arrays.asList(str));


        List<List<String>> ladders = new 单词接龙II().findLadders("qa", "sq", wordList);

//        List<List<String>> ladders = new 单词接龙II().findLadders("hog", "cog", wordList);
        ladders.forEach(System.out::println);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        for (List<String> ladder : ladders) {
            stringStringHashMap.put(ladder.toString(), ladder.get(1));
        }
        System.out.println("===================");
        List<List<String>> ladders1 = new Solution().findLadders("qa", "sq", wordList);
        ladders1.forEach(System.out::println);
        System.out.println(stringStringHashMap.keySet().size() +"===" +ladders.size()+"==="+ladders1.size());


    }



    // 建立一个图
    int[][] edges ;
    Map<String,Integer> map = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        edges   =  new int[wordList.size() + 1][wordList.size() + 1];
        boolean[] visited =  new boolean[wordList.size() + 1];
        map.put(beginWord,0);
        for (int i = 0; i < wordList.size(); i++) map.put(wordList.get(i), i + 1);
        init(beginWord , 0);
        map.forEach((k , v) -> init(k , v));
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> paths = new HashMap<>();
        // 图的层序遍历
        Queue<Integer> queue = new LinkedList<>() , levels = new LinkedList<>();

        int min = wordList.size() + 1;
        // 初始化
        for(int i = 1 ; i < edges.length; i ++){
            if(edges[0][i] == 0) continue;
            queue.add(i);
            levels.add(1);

            List<String> temp = new ArrayList<>();
            temp.add(beginWord);
            temp.add(wordList.get(i - 1));

            paths.put(wordList.get(i - 1)+1,temp);
            if(wordList.get(i - 1).equals(endWord)){
                res.add(temp);
                min = 1;
            }
        }
        visited[0] = true;

        while(!queue.isEmpty() && min != 1 ) {
            int cur = queue.poll() , level = levels.poll();
            String key = wordList.get(cur - 1) + level;
            List<String> pre_path = paths.get(key);

            for(int i = 0 ; i < edges.length && level + 1 <= min; i ++){
                if(edges[cur][i] == 0 || visited[i]) continue;
                ArrayList<String> strings = null;
                try {
                    strings = new ArrayList<>(pre_path);
                }catch (Exception e){
                    System.out.println(key );
                    System.out.println("====");
                    System.out.println(strings);
                    paths.forEach((k , v) -> {
                        System.out.println(k +"==" + v);
                    });

                }
                List<String> next_path = new ArrayList<>(pre_path);
                next_path.add(wordList.get(i - 1));

                if(wordList.get(i - 1).equals(endWord)){
                    min = level + 1;
                    res.add(next_path);
                    break;
                }else paths.put(wordList.get(i - 1) +(level + 1) ,next_path);
                if(level + 1 <= min) {
                    queue.add(i);
                    levels.add(level + 1);
                }
            }
//            paths.remove(key);
            visited[cur] = true;
        }


        return res;
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


    // TODO 超时
    List<List<String>> res = new ArrayList<>();
    Map<String,Boolean> dict = new HashMap<>();
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        for (String s : wordList) {
            dict.put(s,false);
        }
        dfs(beginWord , endWord, new ArrayList<String>() , wordList , 0 , wordList.size());
        dict.clear();
        int min = wordList.size() + 1;
        for (List<String> value : res) {
            min = Math.min(min,value.size());
            dict.put(value.toString(),false);
        }

//        System.out.println(dict);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < this.res.size(); i++) {
            if(this.res.get(i).size() != min || dict.get(this.res.get(i).toString()) == null || dict.get(this.res.get(i).toString())) continue;
            res.add(this.res.get(i));
            dict.put(this.res.get(i).toString(),true);
        }

        return res;
    }

    private void dfs(String beginWord, String endWord, ArrayList<String> path, List<String> wordList , int u  , int n) {
        if(u == n) return;
        if(path.size() == 0) path.add(beginWord);
        if(beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        char[] beginWordCharArray = beginWord.toCharArray() , endWordCharArray = endWord.toCharArray();
        for(int i = 0 ; i < beginWordCharArray.length ; i++) {
            if(beginWordCharArray[i] == endWordCharArray[i]) continue;
            char temp = beginWordCharArray[i];
            beginWordCharArray[i] = endWordCharArray[i];
            String key = new String(beginWordCharArray);
            if(dict.get(key) != null) {
                key = new String(beginWordCharArray);
                if (dict.get(key) != null && !dict.get(key)) {
                    dict.put(key, true);
                    path.add(key);

                    dfs(key, endWord, path, wordList , u + 1 , n );

                    path.remove(path.size() - 1);
                    dict.put(key, false);
                }
                beginWordCharArray[i] = temp;
            }else {
                for (int j = 0; j < wordList.size(); j++) {
                    if (beginWordCharArray[i] == wordList.get(j).charAt(i)) continue;
                    beginWordCharArray[i] = wordList.get(j).charAt(i);
                    key = new String(beginWordCharArray);
                    if (dict.get(key) != null && !dict.get(key)) {
                        dict.put(key, true);
                        path.add(key);

                        dfs(key, endWord, path, wordList , u + 1  , n );

                        path.remove(path.size() - 1);
                        dict.put(key, false);
                    }
                    beginWordCharArray[i] = temp;
                }
            }
        }
    }

}
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
        Set<String> dict = new HashSet<>(wordList);
        // 特殊用例判断
        if (!dict.contains(endWord)) {
            return res;
        }

        dict.remove(beginWord);

        // 第 1 步：广度优先搜索建图
        // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先搜索的第几层
        Map<String, Integer> steps = new HashMap<String, Integer>();
        steps.put(beginWord, 0);
        // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
        Map<String, List<String>> from = new HashMap<String, List<String>>();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                // 将每一位替换成 26 个小写英文字母
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                        dict.remove(nextWord);
                        // 这一层扩展出的单词进入队列
                        queue.offer(nextWord);

                        // 记录 nextWord 从 currWord 而来
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currWord);
                        // 记录 nextWord 的 step
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
            if (found) {
                break;
            }
        }

        // 第 2 步：回溯找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backtrack(from, path, beginWord, endWord, res);
        }
        return res;
    }

    public void backtrack(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(cur)) {
            path.addFirst(precursor);
            backtrack(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }
}