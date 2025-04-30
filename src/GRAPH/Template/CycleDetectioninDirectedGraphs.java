package GRAPH.Template;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectioninDirectedGraphs {

    public static void main(String[] args) {
        int Nodes = 4;
        int[][] Edges ={{0, 1}, {1, 2}, {2, 0},{2, 3}};
    }
    public static boolean hasCylce(int [][]edges , int numnode ){

        List<List<Integer>> graph = new ArrayList<>();
        for (int i =0;i<numnode;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u =edge[0];
            int v= edge[1];
            graph.get(u).add(v);
        }
        int [] visted = new int[numnode]; //
        for (int i =0;i<numnode;i++){
          if(visted[i]==0){
            if(dfs(graph, i, visted)){
                return true;
            }
        }

    }
        return false;
}
public static boolean dfs(List<List<Integer>> graph ,int node , int [] visted){
    if(visted[node]==1)return true;
    if (visted[node]==2) return false;

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

