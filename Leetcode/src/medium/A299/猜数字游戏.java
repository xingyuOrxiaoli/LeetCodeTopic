package medium.A299;

public class 猜数字游戏 {
    public String getHint(String secret, String guess) {
        int[] secret_counts = new int[10], guess_counts = new int[10];
        int n = secret.length() , a = 0 , b = 0 ;
        for(int i = 0 ; i <  n ; i ++){
            if(secret.charAt(i) == guess.charAt(i)) a ++;
            secret_counts[secret.charAt(i) - '0']++;
            guess_counts[guess.charAt(i) - '0']++;
        }
        for(int i  = 0 ; i < 10 ; i ++) b += Math.min(guess_counts[i],secret_counts[i]);
        b -= a;
        return new StringBuilder().append(a).append("A").append(b).append("B").toString();
    }
}
