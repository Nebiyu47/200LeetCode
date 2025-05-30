package BFS;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {

    }
    public static int minimumEffortPath(int[][] hegits){

        int rows = hegits.length;
        int cols= hegits[0].length;
        int[][] efforts = new int[rows][cols];
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int[][] direction = new int[rows][cols];
        while (!pq.isEmpty()){
            int[] curr= pq.poll();
            int effort=curr[0];
            int x = curr[1];
            int y = curr[2];
            if(x==rows-1&&y==cols-1)return effort;

            for (int [] dir : direction){
                int nx=x+dir[0];
                int ny =y+ dir[1];
                if(nx>0&&nx<rows&&ny>0&&ny<cols){
                    int nextEfforts=Math.max(effort,Math.abs(hegits[x][y]-hegits[nx][ny]));
                    if(nextEfforts<efforts[nx][ny]){
                        efforts[nx][ny]=nextEfforts;
                        pq.offer(new int[]{nextEfforts,nx,ny});
                    }
                }
            }
        }
        return 0;
    }

}
