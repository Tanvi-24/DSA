package org.example.Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    class Pair implements Comparable<Pair>{
        int idx;
        int cost;

        public Pair(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public long totalCost(int[] costs, int k, int candidates) {
        ArrayList<Integer> costsList = new ArrayList<>();

        long sum = 0;
        for(int i=0;i<costs.length;i++){
            costsList.add(costs[i]);
        }

        while(k!=0){
            Pair begin = hireWorkerFromStart(costsList,candidates);
            Pair end = hireWorkerFromLast(costsList,candidates);
            if(begin.cost == end.cost){
                if(begin.idx<end.idx){
                    sum+=begin.cost;
                    costsList.remove(begin.idx);
                }
                else{
                    sum+=end.cost;
                    costsList.remove(end.idx);
                }
            }
            else if(begin.cost<end.cost){
                sum+=begin.cost;
                costsList.remove(begin.idx);
            }
            else{
                sum+=end.cost;
                costsList.remove(end.idx);
            }
            k--;
        }

        return sum;
    }

    public Pair hireWorkerFromStart(List<Integer> costs, int candidates){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int i=0;i<candidates && i<costs.size();i++){
            q.add(new Pair(i,costs.get(i)));
        }
        return q.peek();
    }

    public Pair hireWorkerFromLast(List<Integer> costs,int candidates){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int i=costs.size()-1;i>=0 && candidates>0;i--,candidates--){
            q.add(new Pair(i,costs.get(i)));
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int cost[] = {17,12,10,2,7,2,11,20,8};
        int candidates = 4;
        int k=3;
        TotalCostToHireKWorkers t = new TotalCostToHireKWorkers();
        System.out.println(t.totalCost(cost,candidates,k));
    }
}
