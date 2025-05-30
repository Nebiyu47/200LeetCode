package GRAPH.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathLength {
    public static int shortestPathLength(int[][] graph){
        int n= graph.length;
        Queue<int[]>queue= new LinkedList<>();
        boolean[][] visted = new boolean[n][1<<n];
        for (int i=0;i<n;i++){
            queue.offer(new int[]{i,1<<i,0});
            visted[i][1<<i]=true;
        }
        int fullMask=(1<<n)-1;
        while (!queue.isEmpty()){
            int [] curr = queue.poll();
            int node = curr[0];
            int mask=curr[1];
            int steps=curr[2];
            if(fullMask==mask)return steps;
            for (int neigbor : graph[node]){
                int nextMask= mask |(1<<neigbor);
                if(!visted[neigbor][nextMask]){
                    visted[neigbor][nextMask]=true;
                    queue.offer(new int []{neigbor,nextMask,steps+1});
                }
            }
        }
        return -1;
    }
}
