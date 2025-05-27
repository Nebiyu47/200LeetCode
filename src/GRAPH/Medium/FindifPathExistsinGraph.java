package GRAPH.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindifPathExistsinGraph {
    public static void main(String[] args) {

    }
    public static boolean validPath(int n , int [][] edges , int source , int destinations){

        List<List<Integer>> graph = new ArrayList<>();
        for (int i =0;i<edges.length;i++){
            graph.add(new ArrayList<>());
        }
         for( int [] edge : edges){
             int u = edge[0];
             int v = edge[1];
             graph.get(u).add(v);
             graph.get(v).add(u);
        }
         boolean [] visted = new boolean[edges.length];
        for( int  i =0;i<edges.length;i++){
            if(dfs(graph,visted,source,destinations)){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(List<List<Integer>>graph , boolean [] visterd , int node , int destination) {

        if(node==destination)return true;
        visterd[node]= true;
        for (int negibor : graph.get(node)){

            if(!visterd[negibor]){
                if(dfs(graph, visterd, negibor, destination)){
                    return true;
                }
            }
        }
return false;
    }



}
