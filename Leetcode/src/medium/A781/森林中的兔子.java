package medium.A781;

public class 森林中的兔子 {

    public static void main(String[] args) {
        int[] answers = {
                1,1,2
        };
        int i = new 森林中的兔子().numRabbits(answers);
        System.out.println(i);
    }


    public int numRabbits(int[] answers) {
        int res = 0 ;
        int[] map = new int[1000];
        for(int i = 0 ; i < answers.length ; i++){
            if(map[answers[i]] == 0){
                map[answers[i]] = answers[i];
                res += answers[i] + 1;
            }else map[answers[i]] -- ;
        }
        return res;
    }

}
