package medium.A223;

public class 矩形面积 {
    public static void main(String[] args) {
        int i = new 矩形面积().computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(i);
    }


    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x = ax2 - ax1 , y = ay2 - ay1 , res = x * y;
        x = bx2 - bx1 ;
        y = by2 - by1 ;
        res += x * y;
        if(ay2 <= by1 || ay1 >= by2 || ax1 >= bx2 || ax2 <= bx1) return res;
        x = Math.min(ax2 , bx2) - Math.max(ax1 , bx1);
        y = Math.min(ay2 , by2) - Math.max(ay1 , by1);
        res -= x * y;
        return res;
    }

    // TODO 没有利用到下面两个条件，
    // 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
    // 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
    public int computeArea1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x = Math.abs(ax1 - ax2) , y = Math.abs(ay1 - ay2),res = x * y;

        x = Math.abs(bx1 - bx2);
        y = Math.abs(by1 - by2);
        res += x * y;

        // 每一个矩形有四条线
        int[] a = new int[4] , b = new int[4] , c = new int[4];
        // 上 下 左  右 的顺序
        a[0] = Math.max(ay1,ay2);
        a[1] = Math.min(ay1,ay2);
        a[2] = Math.min(ax1,ax2);
        a[3] = Math.max(ax1,ax2);

        b[0] = Math.max(by1,by2);
        b[1] = Math.min(by1,by2);
        b[2] = Math.min(bx1,bx2);
        b[3] = Math.max(bx1,bx2);

        // 检查是否有交叉
        if(a[0] <= b[1] || a[1] >= b[0] || a[2] >= b[3] || a[3] <= b[2]) return res;


        // 删除重复的面积
        c[0] = Math.min(a[0],b[0]);
        c[1] = Math.max(a[1],b[1]);
        c[2] = Math.max(a[2],b[2]);
        c[3] = Math.min(a[3],b[3]);

        x = Math.abs(c[0] - c[1]);
        y = Math.abs(c[3] - c[2]);
        res -= x * y;

        return res;
    }
}
// 第二次的写法
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if(bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2) return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) ;
        int x = Math.min(bx2 , ax2) - Math.max(bx1 , ax1);
        int y = Math.min(by2 , ay2) - Math.max(by1 , ay1);
        System.out.println(x +" == " + y);
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) -  x *  y ;
    }
}