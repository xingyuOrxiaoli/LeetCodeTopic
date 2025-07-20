package difficulty.A212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 单词搜索II {
    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'},
        };

        String[] words = {"oath","pea","eat","rain"};
        List<String> words2 = new Solution().findWords(board, words);
        System.out.println(words2);

        List<String> words1 = new 单词搜索II().findWords(board, words);
        System.out.println(words1);

    }


    // TODO 去除重复路径的问题
    HashSet<String> set = new HashSet<>();
    int[] dx = {-1 ,1 ,0 , 0} , dy = {0 ,0 ,-1 , 1};
    public List<String> findWords(char[][] board, String[] words) {
        // 初始化 trie树
        Trie trie = new Trie();
        Arrays.stream(words).iterator().forEachRemaining(trie::insert);

        int n = board.length , m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board , trie, i , j);
            }
        }
        List<String> res = new ArrayList<>(set);
        return res;
    }

    private void dfs(char[][] board, Trie trie, int i, int j) {
        if(!trie.isChild(board[i][j])) return;

        char ch = board[i][j];
        Trie children = trie.getChildren(ch);
        if(!children.getWord().equals("")){
            set.add(children.getWord());
        }
        board[i][j] = 0;
        for(int k = 0; k < 4; k++) {
            int x = i + dx[k] , y = j + dy[k];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != 0){
                dfs(board , children, x , y);
            }
        }
        board[i][j] = ch;
    }

}
class Trie{

    private String word;
    private Trie[] children;
    private boolean isEnd;


    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
        this.word = "";
    }
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            node = node.getChildren(index);
        }
        node.changeEnd();
        node.setWord(word);
    }

    public boolean isChild(int index) {
        if(index < 'a' || index > 'z') return false;
        return children[index - 'a'] != null;
    }

    public String getWord() {
        return this.word;
    }
    public Trie getChildren(char ch){
        return this.children[ch - 'a'];
    }
    private void setWord(String word) {
        this.word = word;
    }
    private Trie getChildren(int index) {
        if(this.children[index] == null) this.children[index] = new Trie();
        return this.children[index];
    }

    public boolean isEnd() {
        return isEnd;
    }

    private void changeEnd() {
        this.isEnd =  true;
    }
}
class Solution {
    class Trie{
        boolean isEnd ;
        Trie[] children;
        String word;
        public Trie(){
            this.children = new Trie[26];
            this.isEnd = false;
            this.word = "";
        }
        public void insert(String word){
            Trie cur = this;
            for(char ch  : word.toCharArray()){
                int index = ch - 'a';
                if(cur.children[index] == null)
                    cur.children[index] = new Trie();
                // children[index].word = cur.word + ch;
                System.out.println(index);
                cur = cur.children[index];
            }
            cur.isEnd = true;
            cur.word = word;
        }
    }
    HashSet<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word : words){
            root.insert(word);
        }
        int n = board.length , m = board[0].length;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                dfs(board , i , j,root);
            }
        }

        List<String>  res = new ArrayList<>(set);
        return res;
    }
    int[] dx = {1,-1, 0 ,0 } , dy = {0,0,1,-1};
    private void dfs(char[][] board, int x , int y,Trie node){
        char ch = board[x][y];
        if(ch == 0) return ;
        int n = board.length , m = board[0].length , index = ch - 'a';
        if(node.children[index] == null) return ;
        if(node.children[index].isEnd) set.add(node.children[index].word);

         System.out.println(ch + " === " + node.isEnd);
        board[x][y] = 0;
        for(int i = 0 ; i <  4 ; i ++){
            int new_x = dx[i] + x , new_y = dy[i] + y;
            if(new_x > -1 && new_x < n && new_y > -1 && new_y < m && board[new_x][new_y] != 0) dfs(board ,new_x ,new_y,node.children[index]);
        }


        board[x][y] = ch;

    }

}