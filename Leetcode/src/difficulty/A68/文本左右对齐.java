package difficulty.A68;

import java.util.ArrayList;
import java.util.List;

public class 文本左右对齐 {
    public static void main(String[] args) {
        String[] str = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        str = new String[]{"What","must","be","acknowledgment","shall","be"};
//        str = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = new 文本左右对齐().fullJustify(str, 16 );
        for (String s : list) {
            System.out.println(s);
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length , space = 1 , width = 0 , left = 0 , spaceLeft = 0;
        String split = null;
        for (int i = 0; i < n; i++) {
            if(width != 0) width ++;
            if(width + words[i].length() > maxWidth) {
                if(width != 0 ) width -- ;
                width -= i - left - 1;
                if(i - left - 1 != 0) {
                    space = (maxWidth - width) / (i - left - 1);
                    spaceLeft = (maxWidth - width) % (i - left - 1);
                }else{
                    spaceLeft = 0;
                    space = maxWidth - width;
                }
                split = "";
                for(int j = 0; j <  space; j++) split += " ";
                StringBuilder temp = new StringBuilder();
                while (left < i){
                    temp.append(words[left ++]);
                    if (spaceLeft != 0) {
                        temp.append(" ");
                        spaceLeft --;
                    }
                    if(left != i || temp.length() != maxWidth) temp.append(split);
                }
                res.add(temp.toString());
                left = i ;
                width = words[i].length();
            }else width += words[i].length();
        }
        // 最后一行 左对齐
        if(width != 0) {
            StringBuilder temp = new StringBuilder();
            while (left < n ) {
                temp.append(words[left ++]);
                if(temp.length() < maxWidth) temp.append(" ");
            }
            while (temp.length() < maxWidth) temp.append(" ");
            res.add(temp.toString());
        }
        return res;
    }
}
