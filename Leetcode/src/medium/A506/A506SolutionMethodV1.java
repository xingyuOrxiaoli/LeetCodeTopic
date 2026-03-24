package medium.A506;

public class A506SolutionMethodV1  implements A506Solution{

    @Override
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        for(int i = 0; i < n; ++i){
            int site = 1 , rank = score[i];
            for (int k : score) {
                if (rank < k) {
                    site++;
                }
            }
            if(site == 1) {
                res[i] = "Gold Medal";
            } else if(site == 2) {
                res[i] = "Silver Medal";
            } else if(site == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = site + "";
            }
        }

        return res;
    }
}