package org.example.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest,int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        static class Pair implements Comparable<Pair> {
            int v;
            int cost;

            public Pair(int v,int cost){
                this.v = v;
                this.cost = cost;
            }

            @Override //path based sorting
            public int compareTo(Pair p2){
                return this.cost-p2.cost;
            }
        }

        public static void prims(ArrayList<Edge>[] graph){
            boolean visited[] = new boolean[graph.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(0,0));
            int finalCost = 0; //MST cost/total min weight

            while (!pq.isEmpty()){
                Pair curr = pq.remove();
                if(!visited[curr.v]){
                    visited[curr.v] = true;
                    finalCost+= curr.cost;

                    for(int i =0;i<graph[curr.v].size();i++){
                        Edge e = graph[curr.v].get(i);
                        pq.add(new Pair(e.dest,e.weight));
                    }
                }
            }

            System.out.println("final minimum cost to visit all vertices without cycle is "+finalCost);

        }

        //using priority queue
        public static void main(String[] args) {
            int v = 6;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }

            //is cycle - false
            // 0 vertex
            graph[0].add(new Edge(0,1,10));
            graph[0].add(new Edge(0,2,15));
            graph[0].add(new Edge(0,3,30));

            graph[1].add(new Edge(1,0,10));
            graph[1].add(new Edge(1,3,40));

            graph[2].add(new Edge(2,0,15));
            graph[2].add(new Edge(2,3,50));

            graph[3].add(new Edge(3,2,50));
            graph[3].add(new Edge(3,1,40));
            graph[3].add(new Edge(3,0,30));

            int src =0;

            prims(graph);

        }
    }
}
