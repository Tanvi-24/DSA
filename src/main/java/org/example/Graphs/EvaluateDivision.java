package org.example.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String,Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);

            graph.putIfAbsent(u,new HashMap<>());
            graph.get(u).put(v,values[i]);

            graph.putIfAbsent(v,new HashMap<>());
            graph.get(v).put(u,1/values[i]);
        }

        double ans[] = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            ans[i] = dfs(graph,queries.get(i).get(0),queries.get(i).get(1),new HashSet<>());
        }
        return ans;
    }

    public static double dfs(Map<String,Map<String,Double>> graph, String src, String dest, Set<String> visited){
        if(graph.containsKey(src) == false){
            return -1.0;
        }

        if(graph.get(src).containsKey(dest)){
            return graph.get(src).get(dest);
        }

        visited.add(src);
        for(Map.Entry<String,Double> map:graph.get(src).entrySet()){
            if(visited.contains(map.getKey()) == false){
                double val = dfs(graph,map.getKey(),dest,visited);
                if(val!=-1){
                    return map.getValue() * val;
                }
            }
        }
        return -1.-0;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));

        double []values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","c"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        double ans[] = calcEquation(equations,values,queries);
        for (double val:ans) {
            System.out.println(val);
        }
    }
}