package org.example.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentString {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Use a custom comparator to sort by frequency and then lexicographical order
        List<String> result = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(result, (w1, w2) -> {
            int freqCompare = frequencyMap.get(w2) - frequencyMap.get(w1);
            if (freqCompare == 0) {
                // If frequencies are the same, sort lexicographically
                return w1.compareTo(w2);
            }
            return freqCompare;
        });

        // Return the top k words
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        String[] strings ={"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(strings,2));
    }
}
