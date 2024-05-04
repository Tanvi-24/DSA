package org.example.DESHAW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    static ArrayList<Pair>
    createDuplicateArray(String[] wordArr, int size)
    {
        ArrayList<Pair> dupArray = new ArrayList<Pair>();
        for (int i = 0; i < size; i++) {
            Pair p = new Pair(wordArr[i], i);
            dupArray.add(p);

            // pair.first contains the input words and
            // pair.second contains its index
        }
        return dupArray;
    }
    static void printAnagramsTogether(String[] wordArr,
                                      int size)
    {

        ArrayList<Pair> dupArray = new ArrayList<Pair>();

        ; // dupArray to store the word-index pair
        dupArray = createDuplicateArray(
                wordArr, size); // making copy of all the words
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
