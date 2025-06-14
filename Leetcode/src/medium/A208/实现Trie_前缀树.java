package medium.A208;

public class 实现Trie_前缀树 {
    public static void main(String[] args) {

    }

}
class Trie {

    Trie[] children;
    boolean isWord;
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isWord = true;
    }

    public boolean search(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(trie.children[index] == null) return false;
            trie = trie.children[index];
        }
        return trie.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(trie.children[index] == null) return false;
            trie = trie.children[index];
        }
        return true;
    }
}