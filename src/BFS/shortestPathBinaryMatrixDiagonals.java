package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathBinaryMatrixDiagonals {
    public static void main(String[] args) {
       int [][] grid = {
               {0, 1},
               {1, 0}
       };
        System.out.println(shortestPathBinaryMatrixDiagonals(grid));
    }
    public static int shortestPathBinaryMatrixDiagonals(int[][]  grid){
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]!=0||grid[n-1][m-1]!=0)return -1;
        int [][] directions ={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0]=1;
        while (!queue.isEmpty()){
            int [] cell = queue.poll();
            int x = cell[0];
            int y =cell[1];
            int steps = grid[x][y];
            if(x == n-1 && y==n-1) return steps;
            for (int [] dir : directions){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>0&&ny>0&&nx>n&&ny>n&&grid[nx][ny]==0){
                    queue.offer(new int[]{nx,ny});
                    steps=grid[nx][ny]+1;
                }
            }
        }
        return -1;
    }
}
