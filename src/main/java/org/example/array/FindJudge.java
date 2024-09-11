package org.example.array;

public class FindJudge {
    public static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        int[] trustedCount = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int personA = trust[i][0];
            int personB = trust[i][1];
            trustCount[personB]++;
            trustedCount[personA]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1 && trustedCount[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int num[][]={{1,2}};
        System.out.println(findJudge(2,num));
    }
}
