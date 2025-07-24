package DFS;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix){
        if(matrix==null || matrix.length==0)return 0;
        int maxArea=0;
        int col=matrix[0].length;
        int[] height = new int[col];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    height[j]=height[j]+1;
                }else {
                    height[j]=0;
                }
            }
            int area=largestRectanleArea(height);

          maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    private static int largestRectanleArea(int [] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea=0;
        int n = heights.length;
        int[] newHeights= new int[n+1];
        for (int i=0;i<n;i++){
            newHeights[i]=heights[i];
        }
        newHeights[n]=0;
        for(int i=0;i<newHeights.length;i++){
            while (!stack.isEmpty()&&newHeights[i]<newHeights[stack.peek()]){
                int height=newHeights[stack.pop()];
                int width;
                if(stack.isEmpty()){
                    width=i;
                }else {
                    width=i-stack.peek()-1;
                }
                int area=height*width;
                if(area>maxArea){
                    maxArea=area;
                }
            }
            stack.push(i);
        }
        return maxArea;
    }
}
