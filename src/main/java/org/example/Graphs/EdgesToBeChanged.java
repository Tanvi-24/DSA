package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EdgesToBeChanged {

    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static int count = 0;
    public int minReorder(int n, int[][] connections) {
        count = 0;
        ArrayList<Edge>[] graph = new ArrayList[n];
        int edgesChanged = 0;
        boolean visited[] = new boolean[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<connections.length;i++){
            graph[connections[i][0]].add(new Edge(connections[i][0],connections[i][1]));
        }

//        for(int i=0;i<graph.length;i++){
//            if(!visited[i]){
//                dfs(graph,visited,i);
//            }
//        }

        for(int i=0;i<graph.length;i++){
            if(!graph[i].isEmpty()){
                if(!visited[graph[i].get(0).src]){
                    dfs(graph,visited,graph[i].get(0).src);
                }
            }
        }
        return count;

    }

    private boolean dfs(ArrayList<Edge>[] graph, boolean []visited, int curr){

        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!visited[e.dest] && e.dest!=0){
//                count++;
                return dfs(graph,visited,e.dest);
            }
            else if(e.dest == 0){
                return true;
            }
        }
        count++;
        return false;
    }


   /* private void bfs(ArrayList<Edge>[] graph, int n){
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()){
            int src = queue.poll();
            Edge e = graph[]
        }

    }*/
    public static void main(String[] args) {
        EdgesToBeChanged e = new EdgesToBeChanged();


        int connections2[][] = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(e.minReorder(6,connections2));

        int connections3[][] = {{1,0},{1,2},{3,2},{3,4}};
        System.out.println(e.minReorder(5,connections3));

        int [][]connections = {{1,0},{2,0}};
        int sol = e.minReorder(3,connections);
        System.out.println(sol);


        int[][]c = {{1,2},{2,0}};
        System.out.println(e.minReorder(3,c));
    }
}


