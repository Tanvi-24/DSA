package org.example.MS;

import java.util.Arrays;

public class MinimumDaysToWatchMovies {
    public static void main(String[] args) {
        double[] movies = {1.01, 1.4, 1.01, 1.01, 2.4};
        int days = minDaysToWatchMovies(movies);
        System.out.println("Minimum days required to watch all movies: " + days);
    }

    public static int minDaysToWatchMovies(double[] movies) {
        Arrays.sort(movies);
        int days = 0;
        double totalTime = 0;

        for (double movie : movies) {
            totalTime += movie;
            if (totalTime >= 3) {
                days++;
                totalTime = 0;
            }
        }

        if (totalTime > 0) {
            days++;
        }

        return days;
    }
}
