package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public static void main(String[] args) {

    }
    public static int [][]  Matrix(int[][] matrix){
        int row= matrix.length;
        int col=matrix[0].length;
        Queue<int[]>queue= new LinkedList<>();
        boolean [][] isVisted= new boolean[row][col];
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    isVisted[i][j]=true;
                    queue.offer(new int[]{i,j});
                }else {
                    matrix[i][j]=-1;
                }
            }
        }
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            int [] cell=queue.poll();
            int x=cell[0];
            int y=cell[1];
            for (int [] dir :direction){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if(nx>0&&ny>0&&nx<row&&ny<col&&!isVisted[nx][ny]){
                    matrix[nx][ny]=matrix[x][y]+1;
                }
            }
        }
return matrix;
    }

}
