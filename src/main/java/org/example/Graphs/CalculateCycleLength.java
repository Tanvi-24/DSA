package org.example.Graphs;

public class CalculateCycleLength {

    public static int findCycleLength(int[] arr, int startIndex) {
        boolean[] visited = new boolean[arr.length];
        int currentIndex = startIndex;
        int cycleLength = 0;

        while (currentIndex >= 0 && currentIndex < arr.length) {
            // If we revisit the start index, a cycle is found
            if (visited[currentIndex]) {
                return cycleLength;
            }
            // Mark the current index as visited
            visited[currentIndex] = true;
            cycleLength++;
            currentIndex = arr[currentIndex];
        }

        // Return -1 if no cycle is found (out of bounds or other cases)
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {1,2,4,0};
        int a[] = {5, 6, 7, 8, 9,0};
        System.out.println("Length of cycle is " +findCycleLength(array,1));
        System.out.println("Length of cycle is "+findCycleLength(a,0));
    }
}
