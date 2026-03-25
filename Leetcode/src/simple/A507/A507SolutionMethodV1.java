package simple.A507;

public class A507SolutionMethodV1  implements A507Solution{

    @Override
    public boolean checkPerfectNumber(int num) {

        int n = (num >> 1);
        int sum = 0;
        for(int i = n ; i > 0 ; i --){
            if(num % i == 0) {
                sum  += i;
            }
        }

        return sum == num;
    }
}