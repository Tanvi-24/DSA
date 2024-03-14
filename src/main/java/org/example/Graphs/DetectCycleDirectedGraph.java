package org.example.Graphs;

import java.util.ArrayList;

public class DetectCycleDirectedGraph {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public static boolean isCycle(ArrayList<Edge>[] graph){
            boolean visited[] = new boolean[graph.length];
            boolean stack[] = new boolean[graph.length];

            for(int i =0 ;i<graph.length;i++){
                if(!visited[i]){
                    if(isCycleUtil(graph,i,visited,stack)){
                        for(int j=0;j<stack.length;j++){
                            System.out.println(j+" "+stack[j]);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr, boolean visited[], boolean stack[]){

            visited[curr] = true;
            stack[curr] = true;
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(stack[e.dest] == true){ //cycle
                    return true;
                }

                if(!visited[e.dest] && isCycleUtil(graph,e.dest,visited,stack)){
                    return true;
                }
            }
            stack[curr] = false;
            return false;


        }
        public static void main(String[] args) {
            int v = 5;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }
//            is cycle - true
            // 0 vertex
            graph[0].add(new Edge(0,2));
            //1 vertex
            graph[1].add(new Edge(1,0));
            //2 vertex
            graph[2].add(new Edge(2,3));
            //3 vertex
            graph[3].add(new Edge(3,0));

            //is cycle - false
            // 0 vertex
//            graph[0].add(new Edge(0,1));
//            graph[0].add(new Edge(0,2));
//            //1 vertex
//            graph[1].add(new Edge(1,3));
//            //2 vertex
//            graph[2].add(new Edge(2,3));


            System.out.println("is cyclic "+isCycle(graph));

        }
    }

}
