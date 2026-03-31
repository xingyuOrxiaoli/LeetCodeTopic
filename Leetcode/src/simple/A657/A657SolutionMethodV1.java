package simple.A657;

public class A657SolutionMethodV1  implements A657Solution{

    @Override
    public boolean judgeCircle(String moves) {
        int up = 0 , left = 0;
        for (char c : moves.toCharArray()) {
            if(c == 'U'){
                up++;
            } else if(c == 'L'){
                left ++;
            } else if(c == 'D'){
                up --;
            } else if(c == 'R'){
                left --;
            }
        }

        return up == 0 && left == 0;
    }
}