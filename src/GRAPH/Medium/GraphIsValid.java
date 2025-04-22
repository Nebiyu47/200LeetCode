package GRAPH.Medium;
//You're given:
//
//        A number n = total number of nodes (labeled from 0 to n - 1).
//
//        A list of edges = pairs of nodes connected by undirected lines.
//
//        You have to check whether these nodes and edges form a valid tree.
//
//        What is a valid tree?
//        A tree in graph terms must follow two rules:
//
//        Connected — You can reach every node from any other node. No node is isolated.
//
//        Acyclic — There are no loops or cycles (e.g., going from a node and coming back to it through a different path).
//
//        If either condition is false, it’s not a valid tree.
//
//        Examples
//        Example 1:
//
//        lua
//        Copy
//        Edit
//        n = 5
//        edges = [[0,1],[0,2],[0,3],[1,4]]
//        Visualize:
//
//        markdown
//        Copy
//        Edit
//        0
//        / | \
//        1  2  3
//        |
//        4
//        No cycles.
//
//        All nodes are connected.
//
//        This is a valid tree.
//
//        Example 2:
//
//        lua
//        Copy
//        Edit
//        n = 5
//        edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
//        Visualize:
//
//        sql
//        Copy
//        Edit
//        Cycle between 1-2-3-1
//        Has a cycle → Not a tree


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphIsValid {
    public static void main(String[] args) {

    }
    public static boolean isGraphIsValid(int[][] edges){

        List<List<Integer>>agjust= new ArrayList<>();

        for (int i =0;i< edges.length;i++){
            agjust.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            agjust.get(u).add(v);
            agjust.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count =1;
        boolean [] visted = new boolean[edges.length];
        visted[0]=true;
        while (!queue.isEmpty()){
            int node = queue.poll();

            for (int  negibor : agjust.get(node)){
                if(!visted[negibor]){
                    visted[negibor]=true;
                    queue.offer(negibor);
                    count++;
                }
            }

        }
        return count==edges.length;
    }
}
