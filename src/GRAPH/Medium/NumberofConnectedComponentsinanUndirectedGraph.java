package GRAPH.Medium;

import java.util.ArrayList;
import java.util.List;

//📘 Problem Summary:
//        Given n nodes labeled from 0 to n - 1 and a list of undirected edges, return the number of connected components in the graph.
//
//        ✅ Example:
//        text
//        Copy
//        Edit
//        Input: n = 5, edges = [[0,1],[1,2],[3,4]]
//        Output: 2
public class NumberofConnectedComponentsinanUndirectedGraph {


    public static void main(String[] args) {

    }
    public static int NumberofConnectedComponentsinanUndirectedGraph(int n , int [][] edges ){

        List<List<Integer>> graph = new ArrayList<>();
        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visted = new boolean[n];
        int count=0;
        for (int i =0;i < n ;i++){
            if(!visted[i]){
                dfs(graph,visted,i);
                count++;
            }
        }
        return count;
    }
    public static void dfs( List<List<Integer>> graph  , boolean [] visted , int i ){
        visted[i]= true;

        for (int negibor : graph.get(i)){
            if(!visted[negibor]){
                dfs(graph,visted,i);
            }
        }
    }
}
