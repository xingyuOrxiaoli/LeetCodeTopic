package simple.A459;

public class A459SolutionMethodV1 implements A459Solution{
    @Override
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s,1) != s.length();
    }
}
