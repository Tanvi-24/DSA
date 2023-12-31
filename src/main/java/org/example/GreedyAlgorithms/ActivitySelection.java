package org.example.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    //time complexity - O(n)
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        //end time basis sorted
        //if end time is not sorted
        //use below sorting method
        int activities[][] = new int[start.length][3];
        for (int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastend = activities[0][2];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastend)
            {
                maxAct++;
                ans.add(activities[i][0]);
                lastend = activities[i][2];
            }
        }
        System.out.println("maximum actitvies : "+ maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.println("A"+ans.get(i)+ "");
        }
        System.out.println();
    }
}
