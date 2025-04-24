package difficulty.A68;

import java.util.ArrayList;
import java.util.List;

public class 文本左右对齐 {
    public static void main(String[] args) {
        String[] str = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        str = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
//        str = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = new 文本左右对齐().fullJustify_2(str, 16 );
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

    public List<String> fullJustify_2(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int width = 0 , left = 0 ,space_avg = 0 , space_more = 0 , n = words.length;
        StringBuilder temp = new StringBuilder(maxWidth),split = new StringBuilder();
        for(int i = 0 ; i < n ; i++ ){
            if(width != 0) width ++;
            width += words[i].length();
            if(width > maxWidth){
                int num = i - left;
                width -=  words[i].length() + num;
                space_avg = (maxWidth - width) / num;
                space_more = (maxWidth - width) % num;
                split.delete(0,split.length());
                for(int t = 0 ; t < space_avg ; t ++ ) split.append(" ");
                while(left < i){
                    temp.append(words[left ++]);
                    if(space_more != 0 ){
                        temp.append(" ");
                        space_more --;
                    }
                    temp.append(split);
                }
                res.add(temp.toString());

                temp.delete(0,temp.length());
                width = words[i].length();
            }
        }
        while(left < n){
            temp.append(words[left ++]);
            if(temp.length() != maxWidth)  temp.append(" ");
        }
        while(temp.length() != maxWidth) temp.append(" ");

        res.add(temp.toString());
        return res;
    }
}
