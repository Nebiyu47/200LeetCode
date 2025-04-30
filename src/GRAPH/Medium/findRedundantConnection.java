package GRAPH.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findRedundantConnection {
    public static void main(String[] args) {
       int[][] graph = {{1,2},{1,3},{2,3}};
        System.out.println(findRedundantConnection(graph));
    }
    public static int [] findRedundantConnection(int[][] edges){

        List<List<Integer>> graph = new ArrayList<>();
        for (int i =0;i<=edges.length;i++){
            graph.add(new ArrayList<>());
        }
        int n=edges.length;
        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] visted = new boolean[n+1];
            if(hasCycle(graph,u,v,visted)){
                return edge;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }
    public static boolean hasCycle(List<List<Integer>> graph , int src , int target , boolean[] visited){
        if (src == target) return true;

        visited[src] = true;
        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
