package org.example.Graphs;

import org.example.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
     static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph,i,visited);
            }
        }

        }

        //O(V+E)
        public static void bfsUtil(ArrayList<Edge>[] graph,int start, boolean visited[]){
            Queue<Integer> q = new LinkedList<>();
            q.add(start); //src
            while(!q.isEmpty()){
                int curr = q.remove();
                if(!visited[curr]){
                    System.out.print(curr+ " ");
                    visited[curr] = true;
                    for(int i=0;i<graph[curr].size();i++) {
                        q.add(graph[curr].get(i).dest);
                    }
                }

            }

        }

        public static void dfs(ArrayList<Edge>[] graph){
            boolean visited[] = new boolean[graph.length];

            for(int i=0;i<graph.length;i++){
                if(!visited[i]){
                    dfsUtil(graph,i,visited);
                }
            }

        }

        public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited){
            System.out.print(curr + " ");
            visited[curr] = true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]){
                    dfsUtil(graph,e.dest,visited);
                }
            }
        }
        public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]){
            if(src == dest){
                return true;
            }
            visited[src] = true;

            for(int i=0;i<graph[src].size();i++){
                Edge e = graph[src].get(i);
                if(!visited[e.dest] && hasPath(graph,e.dest,dest,visited)){
                    return true;
                }
            }
            return false;
        }
        public static void main(String[] args) {
            int v = 7;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }
            // 0 vertex
            graph[0].add(new Edge(0,1,1));
            graph[0].add(new Edge(0,2,1));
            //1 vertex
            graph[1].add(new Edge(1,0,1));
            graph[1].add(new Edge(1,3,1));
            //2 vertex
            graph[2].add(new Edge(2,0,1));
            graph[2].add(new Edge(2,4,1));
            //3 vertex
            graph[3].add(new Edge(3,1,1));
            graph[3].add(new Edge(3,4,1));
            ;
            //4 vertex
            graph[4].add(new Edge(4,2,1));
            graph[4].add(new Edge(4,3,1));

            //another graph
            //5 vertex
            graph[5].add(new Edge(5,6,1));
            //6 vertex
            graph[6].add(new Edge(6,5,1));



//            //2's neighbors
//            for(int i=0;i<graph[2].size();i++){
//                Edge e = graph[2].get(i);
//                System.out.println(e.dest+" "+e.weight);
//            }

            System.out.println("bfs");
            bfs(graph);
            boolean visited[] = new boolean[graph.length];

            System.out.println("\ndfs");

            dfs(graph);
            System.out.println("\n"+hasPath(graph,0,5,new boolean[v]));
        }

    }

}
