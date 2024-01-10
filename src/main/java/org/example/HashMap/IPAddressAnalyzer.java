package org.example.HashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IPAddressAnalyzer {

    public static String getMostFrequentIPs(String filePath) {
        TreeMap<String, Integer> ipFrequencyMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line corresponds to a single IP address
                String ipAddress = line.trim();
                ipFrequencyMap.put(ipAddress, ipFrequencyMap.getOrDefault(ipAddress, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find the maximum frequency
        int maxFrequency = Collections.max(ipFrequencyMap.values());

        // Get all IP addresses with the maximum frequency
        List<String> mostFrequentIPs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ipFrequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentIPs.add(entry.getKey());
            }
        }

        // Return the result as a comma-separated string
        return String.join(",", mostFrequentIPs);
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";  // Replace with the actual path to your file
        String result = getMostFrequentIPs(filePath);
        System.out.println("IP address(es) with the highest frequency: " + result);
    }
}
