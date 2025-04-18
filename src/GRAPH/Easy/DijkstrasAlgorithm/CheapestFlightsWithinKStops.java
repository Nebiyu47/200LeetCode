package GRAPH.Easy.DijkstrasAlgorithm;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int [][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(findCheapstPrice(flights,src,dst,k));
    }

    public static int findCheapstPrice( int [][] flights, int src , int dst, int k){
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int [] edge : flights){
            int u = edge[0];
            int v=edge[1];
            int w=edge[2];
            graph.computeIfAbsent(u , x-> new ArrayList<>()).add(new int[]{v,w});
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
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,src,0});
        while (!pq.isEmpty()){
            int [] current =pq.poll();
            int cost =current[0];
            int node=current[1];
            int stop=current[2];
            if(node==dst) return cost;
            if(stop<=k){
                List<int[]>neigbors= graph.getOrDefault(node , new ArrayList<>());
                for (int[] neigbor : neigbors){
                    int next = neigbor[0];
                    int price= neigbor[1];
                    pq.offer(new int[]{cost+price,next,stop+1});
                }
            }
        }

        return -1;
    }
}
