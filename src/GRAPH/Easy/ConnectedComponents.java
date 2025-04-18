package GRAPH.Easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectedComponents {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(ConnectedComponents(edges,n));
    }
    public static int  ConnectedComponents(int[][] edges , int n){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean [] visted = new boolean[n];
        int compoents =0;

//        for (int i = 0; i < graph.size(); i++) {
//            System.out.println(i + " -> " + graph.get(i));
//        }
        for(int i=0;i<n;i++){
            if(!visted[i]){
                dfs(graph,visted,i);
                compoents++;
            }
        }
        return compoents;
    }
    public static void dfs(List<List<Integer>> graph , boolean[] visted, int node){

        visted[node]=true;
        for (int neighbor : graph.get(node)){
            if(!visted[neighbor]){
                dfs(graph,visted,neighbor);
            }
        }
    }
}

