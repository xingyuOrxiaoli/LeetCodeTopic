package medium.A331;

import java.util.Arrays;

    public class 验证二叉树的前序序列化 {

    public static void main(String[] args) {
        boolean res = new 验证二叉树的前序序列化().isValidSerialization("9,#,92,#,#");
        System.out.println(res);
    }
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length() , count = 1;
        for(int i = 0; i < n; i++) {
            if(preorder.charAt(i) == ',')  continue;

            if(preorder.charAt(i) == '#') count -- ;
            else {
                while( i < n - 1 && preorder.charAt(i + 1) != ',') i ++;
                count++;
            }
            if(count == 0 && i != n - 1) return false;
        }
        return count == 0;
    }
}
