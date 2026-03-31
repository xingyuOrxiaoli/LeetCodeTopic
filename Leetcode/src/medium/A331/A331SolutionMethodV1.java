package medium.A331;

public class A331SolutionMethodV1  implements A331Solution{

    @Override
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int count = 1;
        for(int i = 0 ; i < n ; i++){
            char ch = preorder.charAt(i);
            if(ch ==',') {
                continue;
            } else if(ch =='#') {
                count --;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i ++;
                }
                count ++;
            }
            if(count == 0 && i != n - 1){
                return false;
            }
        }
        return count == 0;
    }
}