//package org.example.Heaps;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class CostToHireKWorkers {
//    public long totalCost(int[] costs, int k, int candidates) {
//        List<Integer> arrayList = new ArrayList<>();
//        for(int i: costs){
//            arrayList.add(i);
//        }
//        PriorityQueue<Pair> queue1 = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
//        PriorityQueue<Pair> queue2 = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
//        int i,j;
//        for(i =0;i<candidates && i<costs.length;i++){
//            queue1.add(new Pair(i,costs[i]));
//        }
//        for(j=costs.length-1;j>=costs.length-candidates && j>=0;j--){
//            queue2.add(new Pair(j,costs[j]));
//        }
//
//        return findTotalCost(arrayList,k,candidates,0L,queue1,queue2,i-1,j+1);
//    }
//    class Pair{
//        int key;
//        int value;
//
//        public Pair(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public int getKey() {
//            return key;
//        }
//
//        public void setKey(int key) {
//            this.key = key;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }
//
//    public long findTotalCost(List<Integer> costs, int k, int candidates, long totalCost,PriorityQueue<Pair> queue1, PriorityQueue<Pair> queue2,int i, int j){
//
//        if(k==0){
//            return totalCost;
//        }
//
//
//        Pair p1 = queue1.peek();
//        Pair p2 = queue2.peek();
//
//        if(p1.getValue()<=p2.getValue()){
//            costs.remove(Integer.valueOf(p1.getValue()));
//            queue1.poll();
//            if(i>=0 && i<costs.size()){
//                queue1.add(new Pair(i,costs.get(i)));
//            }
//            else{
//                queue1.add(costs.get(costs));
//            }
//        }
//        else{
//            costs.remove(Integer.valueOf(p2.getValue()));
//            queue2.poll();
//            if(j>=0 && j<costs.size()){
//                queue2.add(new Pair(j,costs.get(j)));
//            }
//        }
//
//
//        totalCost+=Math.min(p1.getValue(),p2.getValue());
//
//        return findTotalCost(costs,k-1,candidates,totalCost,queue1,queue2,i,j-1);
//    }
//    public static void main(String[] args) {
//        CostToHireKWorkers totalCostToHireKWorkers = new CostToHireKWorkers();
//        int costs[] = {1,2,4,1};
//        int k = 3;
//        int candidates = 3;
//        System.out.println(totalCostToHireKWorkers.totalCost(costs,k,candidates));
//    }
//}
