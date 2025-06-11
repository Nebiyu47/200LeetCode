package GRAPH.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findMinHeightTrees {
    public static void main(String[] args) {

    }
    public static List<Integer>findMinHeightTree(int n , int [][] edges){
        List<Integer>result = new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i =0;i<n;i++){
            graph.add(new HashSet<>());
        }
        for (int [] edge : edges){
            int u =edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i=0;i<n;i++){
            if(graph.get(i).size()==1){
                leaves.add(i);
            }
        }
        while (n>2){
            n-=leaves.size();
            List<Integer>newLeaves= new ArrayList<>();
            for (int leaf : leaves){
                int negibor =-1;
                for (int x : graph.get(leaf)){
                    negibor=x;
                    break;
                }
                graph.get(negibor).remove(leaf);
                if(graph.get(negibor).size()==1){
                    newLeaves.add(negibor);
                }
            }
            leaves=newLeaves;
        }
        return leaves;
    }
}
