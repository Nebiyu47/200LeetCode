package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {

    }
    public static void solve(char[][] board){

        int row = board.length;
        int col = board[0].length;
        int [][] direction ={{1,0},{-1,0},{0,-1},{0,1}};
        Queue<int[]>queue = new LinkedList<>();
        for (int i =0;i<row;i++){
            if(board[i][0]=='o') {
                queue.offer(new int[]{i,0});
            }
            if(board[i][col-1]=='o') queue.offer(new int[]{i,col-1});
        }
        for (int i=0;i<col;i++){
            if(board[0][i]=='o')queue.offer(new int[]{0,i});
            if(board[row-1][i]=='o')queue.offer(new int[]{row-1,i});
        }
        while (!queue.isEmpty()){
            int [] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            if(board[x][y]!='o')continue;
            board[x][y]='s';
            for (int [] dir : direction){
                int nx =x+dir[0];
                int ny = y+dir[1];
                if(nx>0&&ny>0&&nx<row&&ny<col&&board[ny][ny]=='o'){
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        for (int i =0;i<row;i++){
            for (int j=0;j<col;j++){
                if(board[i][j]=='o'){
                    board[i][j]='x';
                }else if(board[i][j]=='s'){
                    board[i][j]='o';
                }
            }
        }

    }
}
