package GRAPH.Medium;

import java.util.PriorityQueue;

public class minCostConnectPointsPrimsAlgorithm {
    public static void main(String[] args) {

    }
    public static int minCostConnectedPoint(int[][] points){
        PriorityQueue<int[]>priorityQueu= new PriorityQueue<>((a,b)->a[0]-b[0]);
        priorityQueu.offer(new int[]{0,0});
        int count=0;
        int result=0;
        int n = points.length;
        boolean[] visted = new boolean[n];
        while (count<n){
            int [] curr= priorityQueu.poll();
            int cost =curr[0];
            int u=curr[1];
            if(visted[u])continue;
            visted[u]=true;
            result+=cost;
            count++;
            for (int v=0;v<n;v++){
                int dist = Math.abs(points[u][0]-points[v][0])+
                        Math.abs(points[u][0]-points[v][1]);
                priorityQueu.offer(new int[]{dist,v});
            }
        }
        return result;
    }
}
