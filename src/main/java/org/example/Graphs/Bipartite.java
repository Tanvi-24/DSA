package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    Check whether a given undirected graph is bipartite or not.
    A bipartite graph is a graph where:
    You can divide vertices into two sets (say yellow and green),
    Such that no two adjacent vertices have the same color.

    Use BFS traversal and coloring technique:
    Start with unvisited (uncolored) node.
    Color it with 0 (yellow), then color all its neighbors 1 (green), and so on.
    If any adjacent vertex is already colored with the same color, it's not bipartite.

    Code Breakdown:
    isBipartite(ArrayList<Edge>[] graph):
    color[]: initialized with -1, means unvisited.
    Loop through each vertex.
    If uncolored, start BFS from that node.
    In BFS:
    Assign alternate colors to connected nodes.
    If a conflict is found (i.e. adjacent nodes have same color), return false.
    Edge Class:
    Represents an undirected edge with source and destination.

    Time Complexity:
    O(V + E) – Standard BFS traversal.

    Non-cyclic trees are always bipartite.
    Graphs with odd-length cycles are not bipartite.
 */
public class Bipartite {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public static boolean isBipartite(ArrayList<Edge>[] graph){
            int color[] = new int[graph.length];
            for(int i=0;i<color.length;i++){
                color[i] = -1;
            }
            Queue<Integer> q = new LinkedList<>();

            for (int i=0;i<graph.length;i++){
                if(color[i] == -1){ //bfs
                    q.add(i);
                    color[i] = 0; //yellow
                    while (!q.isEmpty()){
                        int curr = q.remove();
                        for (int j=0;j<graph[curr].size();j++){
                            Edge e = graph[curr].get(j); //e.dest

                            if(color[e.dest] ==  -1){
                                int nextCol = color[curr] == 0 ? 1 : 0;
                                color[e.dest] = nextCol;
                                q.add(e.dest);
                            }
                            else if(color[e.dest] == color[curr]){
                                return false; //not bipartite
                            }
                        }
                    }
                }
            }
            return true;
        }

        public static void main(String[] args) {
            //a non cyclic graph is always a bipartite graph

            int v = 5;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList<>();
            }
            // 0 vertex
            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 2));
            //1 vertex
            graph[1].add(new Edge(1, 0));
            graph[1].add(new Edge(1, 3));
            //2 vertex
            graph[2].add(new Edge(2, 0));
            graph[2].add(new Edge(2, 4));
            //3 vertex
            graph[3].add(new Edge(3, 1));
//            graph[3].add(new Edge(3, 4));
            ;
            //4 vertex
            graph[4].add(new Edge(4, 2));
//            graph[4].add(new Edge(4, 3));

            System.out.println("is graph a bipartite graph: "+ isBipartite(graph));

//            //2's neighbors
//            for(int i=0;i<graph[2].size();i++){
//                Edge e = graph[2].get(i);
//                System.out.println(e.dest+" "+e.weight);
//            }

            // 2 0 3 0
            // 0 1 2 3
        }
    }
}
