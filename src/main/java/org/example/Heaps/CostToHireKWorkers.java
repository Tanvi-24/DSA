package org.example.Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        List<Integer> arrayList = new ArrayList<>();
        for(int i: costs){
            arrayList.add(i);
        }
        return findTotalCost(arrayList,k,candidates,0L);
    }
    class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public long findTotalCost(List<Integer> costs, int k, int candidates, long totalCost){

        if(k==0){
            return totalCost;
        }

        PriorityQueue<Pair> queue1 = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        PriorityQueue<Pair> queue2 = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        for(int i =0;i<candidates && i<costs.size();i++){
            queue1.add(new Pair(i,costs.get(i)));
        }
        for(int j=costs.size()-1;j>=costs.size()-candidates && j>=0;j--){
            queue2.add(new Pair(j,costs.get(j)));
        }
        Pair p1 = queue1.poll();
        Pair p2 = queue2.poll();
        if(p1.getValue()<p2.getValue()){
            costs.remove(p1.getKey());
        }
        else{
            costs.remove(p2.getKey());
        }

        totalCost+=Math.min(p1.getValue(),p2.getValue());

        return findTotalCost(costs,k-1,candidates,totalCost);
    }
    public static void main(String[] args) {
        TotalCostToHireKWorkers totalCostToHireKWorkers = new TotalCostToHireKWorkers();
        int costs[] = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        System.out.println(totalCostToHireKWorkers.totalCost(costs,k,candidates));
    }
}
