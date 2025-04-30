package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberIslands {
    public int numIslands(char[][] grid){
        if(grid==null|| grid.length==0) return 0;

        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid , int i , int j){
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]>queue= new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j]='0';
        while (!queue.isEmpty()){
            int [] curr= queue.poll();
            int row=curr[0];
            int col=curr[1];
            for (int [] dir : direction){
                int r = row+dir[0];
                int c = col+dir[1];

                if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[i][j]=='1'){
                    queue.offer(new int[]{r,c});
                    grid[i][j]='0';
                }
            }
        }
    }
}
