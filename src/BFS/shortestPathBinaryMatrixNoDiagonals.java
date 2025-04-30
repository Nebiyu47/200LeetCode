package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathBinaryMatrixNoDiagonals {
    public static void main(String[] args) {

    }
    public static  int shortestPathBinaryMatrixNoDiagonals(int [][] gird){
        int n=gird.length;
        int m =gird[0].length;
        if(gird[0][0]!=0||gird[n-1][m-1]!=0)return 0;
        int [][] direction ={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        gird[0][0]=1;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y =current[1];
            int steps =gird[x][y];
            if(x==n-1 && y==n-1) return steps;
             for( int [] dire: direction ){
                 int nx = x+dire[0];
                 int ny = y+dire[1];
                 if(nx>0&&nx<n&&ny>0&&ny<gird[0].length&&gird[nx][ny]==0){
                     queue.offer(new int[]{nx, ny});
                     gird[nx][ny]=steps+1;
                 }

             }
        }
        return -1;
    }
}
