package org.example.DESHAW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
    Ek string array (wordArr) given aahe.
    Tumhala tyachya madhil anagrams (same letters, different order) ekatra print karayche aahet
    — aapan sorting + indexing vaparla aahe to group them together.
    ✅ Logic Breakdown:
    1. Pair Class:
    Ek Pair object banavla jithe:
    x = word
    y = original index
    Comparable interface implement kelay so that we can sort based on word.
    2. Steps:
    Create dupArray → duplicate list of all words with their original index.
    Sort Each Word’s Characters:
    Each word convert to char[], sort it alphabetically (eg: "cat" → "act")
    Update dupArray with sorted word but keep the original index.
    Sort dupArray:
    After character sorting, sort the entire array so that anagrams group together.
    Print Original Words:
    Use original index stored in Pair.y to fetch original word from wordArr.
    ✅ Example:
    Input:  [cat, dog, tac, god, act]
    After sorting each word:
            [act, dgo, act, dgo, act]

    After sorting all pairs:
            [act, act, act, dgo, dgo]

    Final Output (using original index):
            cat tac act dog god
    Anagrams are grouped together ✅
    ✅ Time Complexity:
    Sorting each word: O(n * k log k) (n = number of words, k = avg length)
    Sorting dupArray: O(n log n)
    Overall: O(n * k log k + n log n)
    ✅ Conclusion:
    Efficient way to group and print anagrams together using:
    Character sorting
    Custom Pair class
    Index tracking for original word mapping
    Perfect for grouping anagrams in interviews or text-processing apps.
 */
public class PrintAnagrams {
    static class Pair implements Comparable<Pair> {
        String x;
        int y;
        public Pair(String x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o)
        {
            return this.x.compareTo(o.x);
        }
    }
    static ArrayList<Pair> createDuplicateArray(String[] wordArr, int size)
    {
        ArrayList<Pair> dupArray = new ArrayList();
        for (int i = 0; i < size; i++) {
            Pair p = new Pair(wordArr[i], i);
            dupArray.add(p);

            // pair.first contains the input words and
            // pair.second contains its index
        }
        return dupArray;
    }
    static void printAnagramsTogether(String[] wordArr, int size)
    {
        ArrayList<Pair> dupArray;

        ; // dupArray to store the word-index pair
        dupArray = createDuplicateArray(wordArr, size); // making copy of all the words
        // and their respective index

        // Iterate through all words in dupArray and sort
        // characters in each word.
        for (int i = 0; i < size; ++i) {
            Pair e = dupArray.get(i);
            char[] arr = e.x.toCharArray();
            Arrays.sort(arr);
            String x = String.valueOf(arr);
            Pair p = new Pair(x, e.y);
            dupArray.set(i, p);
        }

        // now sort the whole vector to get the identical
        // words together
        Collections.sort(dupArray);

        // now all the identical words are together but we
        // have lost the original form of string so through
        // index stored in the word-index pair fetch the
        // original word from main input
        for (int i = 0; i < size; ++i)
            System.out.print(wordArr[dupArray.get(i).y]
                    + " ");
    }

    public static void main(String[] args)
    {
        String[] wordArr
                = { "cat", "dog", "tac", "god", "act" };
        printAnagramsTogether(wordArr, wordArr.length);
    }
}
