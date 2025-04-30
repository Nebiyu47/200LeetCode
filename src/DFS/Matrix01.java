package DFS;

public class Matrix01 {
    public static void main(String[] args) {
      int[][]  mat = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(matrix(mat));
    }
    public static int[][] matrix(int[][] matrix){

        int rows= matrix.length;
        int col= matrix[0].length;
        int[][] dist = new int[rows][col];
        for (int i=0;i<rows;i++){
            for (int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    dist[i][j]=0;
                }else {
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0;i<dist.length;i++){
            for (int j=0;j<dist[0].length;j++){
                System.out.println(dist[i][j]);
            }
        }
        return dist;
    }
    public void dfs(int [][] mat , int [][] dist , int i , int j , int row , int col) {
        int[][] dirction = {{1, 0}, {-1, 0}, {0, 1},{0,-1}};
        for (int [] dir : dirction){
            int x = i+dir[0];
            int y= j+dir[1];
            if(i>=0&&i<row&&j>=0&&j<col){
                if(dist[x][y]>dist[i][j]+1){
                    dist[x][y]=dist[i][j]+1;
                    dfs(mat,dist,i,j,row,col);
                }
            }
        }
    }

}
