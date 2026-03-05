package simple.A1758;

public class A1758SolutionMethod1 implements A1758Solution{
    @Override
    public int minOperations(String s) {
        int n = s.length();
        int firstChange = 1 , secondChange = 0;
        char secondChar  = s.charAt(0) , firstChar = (char) ('1' - secondChar + '0');
        for(int i = 1 ; i < n ; i++) {
            char currentChar = s.charAt(i);

            if(currentChar == firstChar) {
                firstChange++;
            }
            if(currentChar == secondChar) {
                secondChange++;
            }
            firstChar = (char)('1' - firstChar + '0');
            secondChar =  (char)('1' - secondChar + '0');
        }
        return Math.min(firstChange, secondChange);
    }
}
