package simple.A405;


public class A405SolutionMethodV1 implements A405Solution{


    private final long MAX_NUM = 0xffffffffL;

    @Override
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder res =  new StringBuilder();

        long t = num;
        if(t < 0) {
            t = (MAX_NUM + num + 1);
        }

        while (t != 0) {
            res.append(getHex((int) (t % 16)));
            t /= 16;
        }

        return res.reverse().toString();
    }

    private char getHex(int i) {

        if( i < 10 ) {
            return (char) (i + '0');
        }
        switch (i) {
            case 10: return 'a';
            case 11: return 'b';
            case 12: return 'c';
            case 13: return 'd';
            case 14: return 'e';
            case 15: return 'f';
        }
        return ' ';
    }
}
