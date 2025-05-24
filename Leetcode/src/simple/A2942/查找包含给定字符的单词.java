package simple.A2942;

import java.util.ArrayList;
import java.util.List;

public class 查找包含给定字符的单词 {
    public static void main(String[] args) {

    }
    // 使用String 中包含函数
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) res.add(i);
        }

        return res;
    }
}
