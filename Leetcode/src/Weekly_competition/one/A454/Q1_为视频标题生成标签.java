package Weekly_competition.one.A454;

public class Q1_为视频标题生成标签 {
    public static void main(String[] args) {
        String s = new Q1_为视频标题生成标签().generateTag(" fPysaRtLQLiMKVvRhMkkDLNedQKffPnCjbITBTOVhoVjiKbfSawvpisDaNzXJctQkn");
        System.out.println(s);
        s = new Q1_为视频标题生成标签().generateTag("FkVsgzfhQxPYKr WtaCvDuHQeo roeVHIoPorZuIuMDxhYVs jlfCrXCDqBVjgmzxxmZOpUpCc  eHMpZrNxilBPngylMcS");
        System.out.println(s);
        s = new Q1_为视频标题生成标签().generateTag("Lec l hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println(s.equals("#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"));
        System.out.println(s.length());
        String[] split = "   ".split(" ");
        System.out.println(split[0]);
    }
    public String generateTag(String caption) {
        StringBuilder res = new StringBuilder();
        String[] split = caption.trim().split(" ");
        res.append("#");
        int n ;
        if (split.length > 0) {
             n = Math.min(100 - res.length() , split[0].length());
            res.append(split[0].substring(0,n).toLowerCase());
        }

        for (int i = 1; i < split.length && res.length() < 100; i++) {
            if("".equals(split[i])) continue;
            res.append(split[i].substring(0,1).toUpperCase());
            if(res.length() == 100) break;
            n = Math.min(100 - res.length() + 1 , split[i].length());
            res.append(split[i].substring(1,n).toLowerCase());
        }

        return res.toString();
    }

}
class Solution {
    public String generateTag(String caption) {
        StringBuilder res = new StringBuilder();
        res.append("#");
        int n = caption.length();
        boolean first = true , start = true;
        for(int i = 0 ; i < n && res.length() < 100; i ++){
            if(caption.charAt(i) == ' ') {
                first = true;
                continue;
            }
            if(start){
                res.append(caption.substring(i , i +1).toLowerCase());
                start = false;
                first = false;
            }else{
                if(first) res.append(caption.substring(i , i +1).toUpperCase());
                else res.append(caption.substring(i , i +1).toLowerCase());
            }
        }

        return res.toString();
    }
}