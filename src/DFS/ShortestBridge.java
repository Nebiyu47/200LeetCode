package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortageBridge(int[][] grid){
        int n=grid.length;
        Queue<int[]>queue= new LinkedList<>();
        boolean found=false;

        for(int i=0;i<n;i++){
            if(found)break;
            for (int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,queue);
                    found=true;
                    break;
                }
            }
        }
        int steps=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-- >0){
                int[] cell = queue.poll();

                 for (int [] dir : directions){
                     int ni=cell[0]+dir[0];
                     int nj =cell[1]+dir[1];
                     if(ni>=0&&nj>=0&&ni<n&&nj<n){
                         if(grid[ni][nj]==1)return steps;
                         if(grid[ni][nj]==0){
                             queue.offer(new int[]{ni,nj});
                             grid[ni][nj]=-1;
                         }
                     }
                 }
            }
            steps++;
        }
        return -1;
    }
    private void dfs(int[][] grid, int i , int j , Queue<int[]>queue){
        int n=grid.length;
        if(i<0||j<0||i>=n||j>=n||grid[i][j]!=1)return;
        grid[i][j]=-1;
        queue.offer(new int[]{i,j});
        for (int [] dir :directions){
            dfs(grid,i+dir[0],j+dir[1],queue);
        }
    }
}
