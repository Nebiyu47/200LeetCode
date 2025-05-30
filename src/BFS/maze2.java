package BFS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class maze2 {
    public static void main(String[] args) {

    }
    public static int shortDistance(int[][] maze , int[] start , int[] destination){

        int n=maze.length;
        int m=maze[0].length;
        int[][] dist = new int[n][m];
        for (int [] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int [][] direction ={{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]>heap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        heap.offer(new int[]{start[0],start[1],0});
        while (!heap.isEmpty()){
            int[] curr = heap.poll();
            int x =curr[0];
            int y=curr[1];
            int d=curr[2];
            if(x==destination[0]&&y==destination[1])return d;
            for (int [] dir : direction){
                int nx=x+dir[0];
                int ny =y+dir[1];
                int count=0;
                while (nx>=0&&nx<n&&ny>=0&&ny<m&&maze[nx][ny]==0){
                    nx+=dir[0];
                    ny+=dir[1];
                    count++;
                }
                nx-=dir[0];
                ny-=dir[1];
                if(dist[x][y]+count<dist[nx][ny]){
                    dist[nx][ny]=dist[x][y]+count;
                    heap.offer(new int[]{nx,ny, dist[nx][ny]});
                }

            }
        }
        return -1;

    }
}
