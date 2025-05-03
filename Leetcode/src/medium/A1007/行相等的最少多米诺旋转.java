package medium.A1007;

public class 行相等的最少多米诺旋转 {

    public static void main(String[] args) {

        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};
        int i = new 行相等的最少多米诺旋转().minDominoRotations(tops, bottoms);
        System.out.println(i);


    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] dict_tops = new int[7] , dict_bottoms = new int[7];
        for(int i = 0 ; i < tops.length ; i++) {
            dict_tops[tops[i]]++;
            dict_bottoms[bottoms[i]]++;
        }
        int val = 0 ;
        for(int i = 1 ; i < dict_tops.length ; i++) {
            if(dict_tops[i] + dict_bottoms[i] >= tops.length){
                val = i;
                break;
            }
        }
        if(val == 0) return -1;
        // 往上交换
        for(int i = 0 ; i < tops.length ; i ++){
            if(val == tops[i]) continue;
            if(val != bottoms[i]) return  -1;
        }
        return tops.length - Math.max(dict_tops[val] , dict_bottoms[val]);
    }
}
