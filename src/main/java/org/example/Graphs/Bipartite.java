package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
