package DFS;

public class NumberofIslands {
    public static void main(String[] args) {

    }
    public static int NumberofIslands(int [][] nums ){

        int row = nums.length;
        int col= nums[0].length;

        int numberIslands=0;
        boolean[][] visted = new boolean[row][col];

        for (int i =0;i<row;i++){
            for (int j=0;j<col;j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                    numberIslands++;
                }
            }
        }
        return numberIslands;
    }
    public static void dfs(int[][] grid , int row , int col ){
        int n=grid.length;
        int m = grid[0].length;
        if(row<0||row>=n|| col<0 ||col>=m|| grid[row][col]==0){
            return;
        }
        grid[row][col]=0;

        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);

    }
}
