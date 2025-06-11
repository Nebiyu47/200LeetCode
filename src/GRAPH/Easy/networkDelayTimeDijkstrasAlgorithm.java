package GRAPH.Easy;

import java.util.*;

public class networkDelayTimeDijkstrasAlgorithm {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelys(times, n, k));
    }
    public static int networkDelys(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, w});
        }
        System.out.println("Graph contents:");
        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            int fromNode = entry.getKey();
            List<int[]> neighbors = entry.getValue();
            System.out.print("From " + fromNode + " -> ");
            for (int[] pair : neighbors) {
                int toNode = pair[0];
                int weight = pair[1];
                System.out.print("(" + toNode + ", " + weight + ") ");
            }
            System.out.println(); // newline after each node
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] currenty = pq.poll();
            int nude = currenty[0];
            int time = currenty[1];
            if (dist.containsKey(nude)) {
                continue;
            }
            dist.put(nude, time);
            if (graph.containsKey(nude)) {
                for (int[] neigbor : graph.get(nude)) {
                    int nextNode = neigbor[0];
                    int travelTime = neigbor[1];
                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{nextNode, time + travelTime});
                    }
                }
            }
        }
            if (dist.size() != n) {
                return -1;
            }
            int maxTime = 0;
            for (int t : dist.values()) {
                maxTime = Math.max(maxTime, t);
            }
            return maxTime;
        }


    }
