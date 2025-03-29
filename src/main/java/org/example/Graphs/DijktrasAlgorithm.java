package org.example.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
/*
    Aplyala ek weighted graph dila ahe (with positive weights),
    and aplyala source node pasun saglya nodes paryant shortest path
    find karaycha ahe using Dijkstra's Algorithm.

    Dijkstra’s Algorithm is a greedy algorithm.
    It finds minimum distance from src to all other vertices in the graph.
    It uses a PriorityQueue (Min Heap) to always pick the minimum path weight node.

    dist[]: source to each vertex distance track karto.
    PriorityQueue<Pair>: path weight la priority dyato (smallest path first).
    visited[]: ek node la ekda visit zala ki parat consider nahi karto.

    Algorithm Flow:
    Initialize dist[]:
    saglyana Integer.MAX_VALUE, except source la 0.
    Add source in PQ with path 0.
    While PQ is not empty:
    Remove the pair with min path.
    Mark as visited.
    Traverse all neighbors.
    dist[u] + wt < dist[v] → update distance and add to PQ.

    Time Complexity:
    With PriorityQueue: O(V + E log V)
    Without PQ: O(V^2)

    Dijkstra’s algo efficiently finds shortest paths using a min-heap.
    Works only with positive edge weights.
    dist[] is updated only when shorter path is found.
 */
//greedy algorithm to find shortest path
public class DijktrasAlgorithm {
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

        //time complexity - O(V+E*log(V))
        //without priority queue O(V^2)
        public static void dijkstra(ArrayList<Edge>[] graph, int src){
            int dist[] = new int[graph.length]; //dist[i] -> src to i

            for(int i=0;i<graph.length;i++){
                if(i!=src){
                    dist[i] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(src,0));

            boolean visited[] = new boolean[graph.length];
            //bfs loop
            while (!pq.isEmpty()){
                Pair curr = pq.remove();
                if(!visited[curr.n]){
                    visited[curr.n] = true;
                    //neighbors
                    for(int i =0; i<graph[curr.n].size();i++){
                        Edge e = graph[curr.n].get(i);
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.weight;
                        if(dist[u]+ wt <dist[v]){ //update dist from src to v
                            dist[v] = dist[u]+wt;
                            pq.add(new Pair(v,dist[v]));
                        }
                    }
                }
            }

            for(int i=0;i<dist.length;i++){
                System.out.println(dist[i]);
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

            dijkstra(graph,src);

        }
    }
}
