package medium.A211;

import java.util.LinkedList;
import java.util.Queue;

public class 添加与搜索单词_数据结构设计 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // 返回 False
        wordDictionary.search("bad"); // 返回 True
        wordDictionary.search(".ad"); // 返回 True
        wordDictionary.search("b.."); // 返回 True
    }
}
class WordDictionary {

    boolean last ;
    WordDictionary[] dict ;

    public WordDictionary() {
        dict = new WordDictionary[26];
        last = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.dict[index] == null) node.dict[index] = new WordDictionary();
            node = node.dict[index];
        }
        node.last = true;
    }

    public boolean search(String word) {
        Queue<WordDictionary> queue = new LinkedList<>();
        Queue<Integer> indexs = new LinkedList<>();
        queue.offer(this);
        indexs.add(0);
        while (!queue.isEmpty()) {
            WordDictionary node = queue.poll();
            Integer index = indexs.poll();
            if(node == null) continue;
            if(index == word.length()){
                if(node.last) return true;
                else continue;
            }
            if(word.charAt(index) != '.'){
                queue.offer(node.dict[word.charAt(index) - 'a']);
                indexs.add(index + 1);
            }else{
                for(int i = 0 ; i < 26; i++){
                    if(node.dict[i] == null) continue;
                    queue.offer(node.dict[i]);
                    indexs.add(index + 1);
                }
            }
        }
        return false;
    }
}