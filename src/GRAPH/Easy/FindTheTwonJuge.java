package GRAPH.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindTheTwonJuge {
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1,3},{2,3},{3,1}};
    }
    public static int findJusge(int n , int[][] edges){

        List<List<Integer>>graph = new ArrayList<>();
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for (int [] edge: edges){
            int u =edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        int[] visted = new int[n+1];
        for (int i =0;i<=n;i++){
             if(visted[i]==0){
                 if(dfs(graph,i,visted)){
                     return -1;
                 }
             }
        }
        return n;
    }
    public static boolean dfs(List<List<Integer>>graph , int node , int[] visted){
        if(visted[node]==1)return true;
        if(visted[node]==2)return false;

        visted[node]=1;
        for (int negibor : graph.get(node)){
            if(dfs(graph,negibor,visted)){
                return true;
            }
        }
        visted[node]=2;
        return false;
    }
}
