package GRAPH.Template;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectioninUndirectedGraphs {
    public static void main(String[] args) {
        int Nodes = 4;
        int[][] Edges ={{0, 1}, {1, 2}, {2, 0},{2, 3}};
    }
    public static boolean CycleDetectioninUndirectedGraphs(int[][] edges , int numNodes){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Initialize visited array
        boolean[] visited = new boolean[numNodes];

        // Run DFS from each node
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, -1, i)) {
                    return true;  // Cycle detected
                }
            }
        }
        return false;  // No cycle detected
    }
    private static boolean dfs(List<List<Integer>> graph, boolean[] visited, int parent, int node) {
        // Mark the node as visited
        visited[node] = true;

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            // If the neighbor is not visited, or it's not the parent node (to avoid cycle detection on the edge to the parent)
            if (!visited[neighbor]) {
                if (dfs(graph, visited, node, neighbor)) {
                    return true;  // Cycle detected
                }
            } else if (neighbor != parent) {
                // If the neighbor is already visited and is not the parent, cycle is detected
                return true;
            }
        }
        return false;
 }
}
