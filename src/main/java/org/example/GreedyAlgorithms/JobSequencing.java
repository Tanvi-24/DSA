package org.example.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int id,int deadline,int profit){
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    public static void main(String[] args) {
//        int deadline[] = {4,1,1,1};
//        int profit[] = {20,10,40,30};

        int activities[][] = {{4,20},{1,10},{1,40},{1,30}};
        /*int maxProfit = 0;
        int time = 0;
        Arrays.sort(activities,Comparator.comparingDouble(o->o[1]));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =activities.length-1;i>=0;i--){
            if(activities[i][0]>time){
                time++;
                maxProfit+=activities[i][1];
                ans.add(i);
            }
        }
        */

        ArrayList<Job> jobs = new ArrayList<>();
        int t=0;
        for (int i=0;i<activities.length;i++){
            jobs.add(new Job(i,activities[i][0],activities[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit); //sorting in ascending order
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i =0 ;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadline>t){
                seq.add(curr.id);
                t++;
            }
        }
        System.out.println("Maximum profit is "+seq.size()+ " and is from");
        for (int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}
