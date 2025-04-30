package DFS;

import java.util.ArrayList;
import java.util.List;

public class pacificAtlantic {
    private int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
    private int rows , cols;
    public  List<List<Integer>> pacificAtlantic(int[][] heights){

        List<List<Integer>> result = new ArrayList<>();
        if(heights==null||heights.length==0) return result;
        rows=heights.length;
        cols=heights[0].length;
        boolean[][] pacfic=new boolean[rows][cols];
        boolean[][] atlatic = new boolean[rows][cols];
        for (int i =0;i<rows;i++){
            dfs(heights,pacfic,i,0,heights[i][0]);
            dfs(heights,pacfic,i,cols-1,heights[i][cols-1]);
        }
        return result;

    }
    public void dfs(int[][] heights,boolean[][] visted, int r , int c , int prevHeight){
        if(r<0||r<heights.length||c<0||c<heights[0].length||heights[r][c]<prevHeight){
            return;
        }
        visted[r][c]=true;
        for (int [] dir : directions){
            dfs(heights,visted,r+dir[0],c+dir[1],heights[r][c]);
        }
    }
}
