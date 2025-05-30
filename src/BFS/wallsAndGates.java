package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates {
    private static final int INF=Integer.MAX_VALUE;
    private static final int[][] DIRS={{1,0},{-1,0},{0,1},{0,-1}};
    public void wallsAndGates(int[][]rooms){
        if(rooms==null|| rooms.length==0)return;
        int n=rooms.length;
        int m=rooms[0].length;
        Queue<int[]>queue = new LinkedList<>();
        for (int i =0;i<n;i++){
            for (int j=0;j<m;j++){
                if(rooms[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()){
            int [] curr = queue.poll();
            int x =curr[0];
            int y=curr[1];
            for (int [] dir : DIRS){
                int nx= x+dir[0];
                int ny=y+dir[1];
                if(nx>0&&ny<n&&ny>0&&ny<m&&rooms[nx][ny]==INF){
                    rooms[nx][ny]=rooms[x][y]+1;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }
    }
}
