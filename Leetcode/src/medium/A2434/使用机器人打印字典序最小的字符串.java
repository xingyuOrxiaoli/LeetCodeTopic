package medium.A2434;

import java.util.Stack;

public class 使用机器人打印字典序最小的字符串 {
    public static void main(String[] args) {
        String s = new 使用机器人打印字典序最小的字符串().robotWithString("abddaa");
        System.out.println(s);
    }
    public String robotWithString(String s) {
        int[] dict = new int[26];
        int n = s.length() , min = 0;
        for (int i = 0; i < n; i++) dict[s.charAt(i) - 'a']++;

        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            dict[s.charAt(i) - 'a']--;
            stack.push(s.charAt(i) - 'a');
            while(min != 25 && dict[min] == 0) min ++;
            while (!stack.isEmpty() && min >= stack.peek()) res.append((char)(stack.pop() + 'a'));
        }
        return res.toString();
    }
}
