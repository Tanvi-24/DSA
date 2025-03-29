package org.example.Graphs;

import java.util.ArrayList;
import java.util.Stack;

/*
    Aplyala ek Directed Acyclic Graph (DAG) dila ahe, ani tyacha topological sort find karaycha ahe.
    Topological sort manje ek linear ordering of vertices such that every directed edge u → v,
     u comes before v in ordering.

     Logic (DFS-based Topological Sort):
    public static void topologicalSort(ArrayList<Edge>[] graph)
    visited[]: check karto ki node already visited ahe ka.
    Stack: order maintain karayla je reverse karun final topological order dakhavtoy.

    topSortUtil (Recursive DFS):
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack)
    Current node la visited mark karto.
    Saglya neighbors la DFS call karto.
    Saglya neighbors visit zalyavar, stack.push(curr) karto → means processing complete for that node.

    O(V + E) → for visiting all vertices and edges once

 */
public class TopologicalSort {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }


        public static void topologicalSort(ArrayList<Edge>[] graph){
            boolean visited[] = new boolean[graph.length];
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<graph.length;i++){
                if(!visited[i]){
                   topSortUtil(graph,i,visited,stack);
                }

            }

            while (!stack.isEmpty()){
                System.out.print(stack.pop()+ " ");
            }
        }

        public static void topSortUtil(ArrayList<Edge>[] graph,int curr, boolean visited[], Stack<Integer> stack){
            visited[curr] = true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]){
                    topSortUtil(graph,e.dest,visited,stack);
                }
            }
            stack.push(curr);
        }
        public static void main(String[] args) {
            int v = 5;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }

            //is cycle - false
            // 0 vertex
            graph[0].add(new Edge(0,1));
            graph[0].add(new Edge(0,2));
            //1 vertex
            graph[1].add(new Edge(1,3));
            //2 vertex
            graph[2].add(new Edge(2,3));

            topologicalSort(graph);
        }
    }
}
