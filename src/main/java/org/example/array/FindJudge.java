package org.example.array;
/*
    The code finds town judge by counting trust relationships:
    Counting Trust:
    Code madhe don arrays use kele ahet: ek (trustCount) konala kiti lok trust kartat he count karnyasathi, ani dusra (trustedCount) konta manus kiti lokanna trust karto he count karnyasathi.
    Trust array madhlya pratyek pair [a,b] sathi, trustCount[b] increment karto (manje b la konitari trust karto), ani trustedCount[a] increment karto (manje a ha konala tari trust karto).
    Identifying Judge:
    Judge to manus asel jyala sagle dusre lok trust kartat (trustCount[i] == n - 1) ani to konalach trust karat nahi (trustedCount[i] == 0).
    Code saglya mansanmadhe loop firavun asha judge la shodhto. Judge sapadla tar tyacha number return karto; nahi tar -1 return karto.
    Hya approach mule efficient ani fast judge sapadla jato.

    ********************
    The code finds the town judge by counting trust relationships:
    Counting Trust:
    It uses two arrays: one (trustCount) to count how many people trust each person, and another (trustedCount) to count how many people each person trusts.
    For every pair [a, b] in the trust array, it increments trustCount[b] (person b is trusted) and trustedCount[a] (person a trusts someone).
    Identifying the Judge:
    The judge should be trusted by everyone else (trustCount[i] == n - 1) and should not trust anyone (trustedCount[i] == 0).
    The code loops through all people (from 1 to n) to find such a person. If found, that person is returned; otherwise, it returns -1.
    This approach efficiently checks each person to determine if they meet the judge criteria.

 */
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
