package org.example.Graphs;

import java.util.ArrayList;

public class DetectCycle {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public static boolean detectCycle(ArrayList<Edge>[] graph) {
            boolean visited[] = new boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i]) {

                   if(detectCycleUtil(graph, visited, i, -1)){
                       return true;
                   }
                }
            }
            return false;
        }

        public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visited[], int curr, int parent) {
            visited[curr] = true;

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                //case 3
                if (!visited[e.dest]){
                    if(detectCycleUtil(graph,visited,e.dest,curr))
                        return true; 
                } //case 1
                else if(visited[e.dest] && e.dest != parent){
                    return true;
                    //cycle always exist
                }
                //case 2 -> do nothing/continue
            }
            return false;
        }

        public static void main(String[] args) {
            int v = 5;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }
            // 0 vertex
            graph[0].add(new Edge(0,1,1));
            graph[0].add(new Edge(0,2,1));
            graph[0].add(new Edge(0,3,1));

            //1 vertex
            graph[1].add(new Edge(1,0,1));
            graph[1].add(new Edge(1,2,1));
            //2 vertex
            graph[2].add(new Edge(2,0,1));
            graph[2].add(new Edge(2,1,1));
            //3 vertex
            graph[3].add(new Edge(3,0,1));
            graph[3].add(new Edge(3,4,1));
            ;
            //4 vertex

            graph[4].add(new Edge(4,3,1));

            //another graph
            //5 vertex
//            graph[5].add(new Edge(5,6,1));
//            //6 vertex
//            graph[6].add(new Edge(6,5,1));


            System.out.println(detectCycle(graph));
        }
    }

}
