package org.example.Graphs;

import java.util.ArrayList;
/*
    Aplyala ek directed graph dila ahe with n nodes (0 to n-1) and some connections.
    Tumhala minimum number of edges reorder karaychya ahet such that saglya nodes kadhitari
    node 0 la path den.

    Graph create karto using given connections:
    Add edge from → to with weight 1 (original direction).
    Then add reverse edge to → from with weight 0 (reverse direction as reference only).
    👉 Reverse edge originally exists nahi but add karto tracking sathi.

    DFS + Path Checking:
    For every unvisited node starting from 1 to n-1, call hasPath(graph, i, 0, visited):
    Inside hasPath, jar current edge is a reverse edge (weight == 0) and there's no path
    to 0 from its target,
    Then reverse it by incrementing count++.
    Otherwise, normal DFS continue.
    Function hasPathToZero recursively check karto if target node 0 paryanta path exists
    using reverse + original edges
 */
public class PathsLeadingToZero {

    public static int count = 0;
    public int minReorder(int n, int[][] connections) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<connections.length;i++){
            graph[connections[i][0]].add(new Edge(connections[i][0],connections[i][1],1));
           // graph[connections[i][1]].add(new Edge(connections[i][1],connections[i][0],0));
        }

        for(int i=0;i<graph.length;i++){
            System.out.println(graph[i]);
        }
        System.out.println("***************************************************");
        for(int i=0;i<connections.length;i++){
            graph[connections[i][1]].add(new Edge(connections[i][1],connections[i][0],0));
        }
        for(int i=0;i<graph.length;i++){
            System.out.println(graph[i]);
        }
        boolean visited[] = new boolean[n];
        for (int i = 1; i < graph.length; i++) {

            if(!visited[i]) {
                visited[i] = true;
                hasPath(graph, i, 0, visited);

            }
        }
        return count;
    }

    public void hasPath(ArrayList<Edge> graph[], int src, int dest,boolean []visited){
       visited[src] = true;
        if(src == dest){
            return;
        }

        if(graph[src].size() == 0){
            return;
        }

        for(int i=0;i<graph[src].size();i++) {
            Edge e = graph[src].get(i);
            if(!visited[e.v]) {
                if (e.weight == 0 && !hasPathToZero(graph,e.v,0, new boolean[visited.length])) {
                    count++;
                    e.weight = 1;
                }
                hasPath(graph, e.v, dest,visited);
            }
            else if(hasPathToZero(graph,e.v,0, new boolean[visited.length]) && e.weight == 0){
                count++;
                e.weight = 1;
            }
        }
    }

    public boolean hasPathToZero(ArrayList<Edge>[] graph, int src, int dest,boolean []visited){
        if(src == dest){
            return true;
        }
        visited[src] = true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visited[e.v] && hasPathToZero(graph,e.v,dest,visited)){
                return true;
            }
        }
        return false;
    }

    class Edge{
        int u;
        int v;
        int weight=0;

        public Edge(int u,int v,int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n=6;
        int connections[][]= {{1,0},{1,3},{2,3},{4,0},{4,5}};
        int connections2[][] = {{1,0},{1,2},{3,2},{3,4}};
        PathsLeadingToZero pathsLeadingToZero = new PathsLeadingToZero();
        System.out.println(pathsLeadingToZero.minReorder(n,connections));
        //System.out.println(pathsLeadingToZero.minReorder(5,connections2));
    }
}

