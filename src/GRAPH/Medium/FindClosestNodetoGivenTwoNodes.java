package GRAPH.Medium;

import java.util.Arrays;

public class FindClosestNodetoGivenTwoNodes {
    public int closestMeetingNode(int [] edge, int node1, int node2){
        int n =edge.length;
        int [] dist1 = new int[n];
        int [] dist2= new int[n];
        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);
        dfs(edge,node1,dist1);
        dfs(edge,node2,dist2);
        int minDist=Integer.MAX_VALUE;
        int result =-1;
        for (int i=0;i<n;i++){
            if(dist1[i]!=-1&&dist2[i]!=-1){
                int maxDist=Math.max(dist1[i],dist2[i]);
                if(maxDist<minDist){
                    minDist=maxDist;
                    result=i;
                }
            }
        }
        return result;

    }
    public void dfs(int [] edge , int node , int [] dist){
        int distance=0;
        while (node!=-1 && dist[node]!=-1){
            dist[node]=distance++;
            node=edge[node];
        }
    }
}
