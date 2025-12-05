package BFS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {

    }
    public static int minimumEffortPath(int[][] hegits){

      int row = hegits.length;
      int col=hegits[0].length;
      int [][] efforts = new int[row][col];
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
      pq.offer(new int[]{0,0,0});
      for (int i=0;i<row;i++) Arrays.fill(efforts[i],Integer.MAX_VALUE);
      int[][] direction = {{1,0},{0,-1},{-1,0},{0,1}};
      while (!pq.isEmpty()){
          int [] cell = pq.poll();
          int effort=cell[0];
          int X=cell[1];
          int Y=cell[2];
          if(X==row-1&&Y==col-1) return effort;
          for (int [] dir : direction){
              int nx= X+dir[0];
              int ny=Y+dir[1];
              if(nx>0&&nx<row&&ny>0&&ny<col){
                  int nextEfforts=Math.max(effort,Math.abs(hegits[X][Y]-hegits[nx][ny]));
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
