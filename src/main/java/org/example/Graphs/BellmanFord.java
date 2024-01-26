package org.example.Graphs;

import java.util.ArrayList;
//used for negative edge values
//dp based algorithm
//time complexity - O(V*E)
//cannot use for negative weighted cycle
public class BellmanFord {
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
            int n;
            int path;

            public Pair(int n,int path){
                this.n = n;
                this.path = path;
            }
            @Override //path based sorting
            public int compareTo(Pair p2){
                return this.path-p2.path;
            }
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
            graph[0].add(new Edge(0,1,2));
            graph[0].add(new Edge(0,2,4));
            graph[1].add(new Edge(1,2,1));
            graph[1].add(new Edge(1,3,7));
            //2 vertex
            graph[2].add(new Edge(2,4,3));
            graph[3].add(new Edge(3,5,1));
            graph[4].add(new Edge(4,3,2));
            graph[4].add(new Edge(4,5,5));
            int src =0;

        }
    }
}
