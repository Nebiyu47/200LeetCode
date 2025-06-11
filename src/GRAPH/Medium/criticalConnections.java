package GRAPH.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class criticalConnections {
    private static int time = 0;
    private static List<List<Integer>> bridges = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static List<List<Integer>> crticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> conection : connections) {
            graph.get(conection.get(0)).add(conection.get(1));
            graph.get(conection.get(1)).add(conection.get(0));
        }
        int[] dis = new int[n];
        int[] low = new int[n];
        Arrays.fill(dis, -1);
        for (int i = 0; i < n; i++) {
            if (dis[i] == -1) {
                dfs(i, -1, dis, low, graph);
            }
        }
        return bridges;
    }

    public static void dfs(int u, int parent, int[] disc, int[] low, List<List<Integer>> graph) {
        disc[u] = time++;
        low[u] = time++;
        for (int v : graph.get(u)) {
            if (disc[v] == -1) {
                if (v == parent) {
                    continue;
                }
                dfs(v, u, disc, low, graph);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}