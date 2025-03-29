package org.example.Graphs;

import java.util.ArrayList;
/*
    Find all possible paths from a given source node to a target node in a directed graph.
    Use recursive DFS (Depth First Search) to explore all paths.
    Maintain an ArrayList to keep track of the current path.
    When the current node equals the target, print the path.
    After exploring one neighbor, backtrack by removing the last node.

    Code Details:
    srcToTarget():
    This method starts the process.
    It creates an empty list and calls the helper util() with source and target.
    util():
    Add the current source to the list.
    If src equals target, print the list (this is one complete path).
    Otherwise, iterate through all edges from the current node.
    For each edge, recursively call util() for the destination.
    After the recursive call, backtrack by removing the last added node from the list.
    Graph Representation:
    The graph is stored as an array of ArrayLists, where each list contains outgoing edges from that vertex.
    Each Edge has a source (src) and a destination (dest).
 */
public class AllPathsFromSrcToTarget {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public static void srcToTarget(ArrayList<Edge>[] graph, int src, int target){
           ArrayList<Integer> list = new ArrayList<>();
           util(graph,src,target,list);
        }

        //Time complexity - exponential
        public static void util(ArrayList<Edge>[] graph, int src, int target,ArrayList<Integer> list){
            list.add(src);

            if(src == target){
               for(int i=0;i<list.size();i++){
                   System.out.print(list.get(i)+" ");
               }
                System.out.println();
               return;
            }
            for(int i=0;i<graph[src].size();i++){
                Edge e = graph[src].get(i);
                util(graph,e.dest,target,list);
                list.remove(list.size()-1);
            }
        }



        public static void main(String[] args) {
            int v = 6;

            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }

            //is cycle - false
            // 0 vertex
            graph[0].add(new Edge(0,3));
            //2 vertex
            graph[2].add(new Edge(2,3));
            graph[3].add(new Edge(3,1));
            graph[4].add(new Edge(4,1));
            graph[4].add(new Edge(4,0));
            graph[5].add(new Edge(5,2));
            graph[5].add(new Edge(5,0));

            srcToTarget(graph,5,1);
        }
    }
}
