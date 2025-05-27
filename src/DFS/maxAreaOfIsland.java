package DFS;

public class maxAreaOfIsland {
    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] gird) {

        int row = gird.length;
        int col = gird[0].length;
        boolean[][] visted = new boolean[row][col];
        int maxAra = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (gird[row][col] == 1) {
                    maxAra = Math.max(maxAra, dfs(gird, i, j, visted));
                }
            }

        }
        return maxAra;

    }
public static int dfs(int[][] gird, int row , int col, boolean[][] visted){

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        int area=0;
        if(row<gird.length||row<0||col<0||col>gird[0].length||visted[row][col]==true){
            return 0;
        }
        visted[row][col]=true;
        area+=dfs(gird, row+1, col, visted);
    area+=dfs(gird, row-1, col, visted);
    area+=dfs(gird, row, col+1, visted);
    area+=dfs(gird, row, col-1, visted);

    return area;
}
}
