package org.example.DESHAW;

public class EggDrop {
    public static int superEggDrop(int k, int n) {
        int[][] dp=new int[k+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[j][i]=dp[j-1][i-1]+dp[j][i-1]+1;
                if(dp[j][i]>=n) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(1,2));
    }
}
