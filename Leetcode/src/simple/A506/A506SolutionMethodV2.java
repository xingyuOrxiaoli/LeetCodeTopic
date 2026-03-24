package simple.A506;

import java.util.Arrays;

public class A506SolutionMethodV2 implements A506Solution{

    @Override
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(a,b)-> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            int site = arr[i][1];
            System.out.println(site);
            if(i == 0) {
                res[site] = "Gold Medal";
            } else if(i == 1) {
                res[site] = "Silver Medal";
            } else if(i == 2) {
                res[site] = "Bronze Medal";
            } else {
                res[site] = i + 1 + "";
            }
        }
        return res;
    }
}