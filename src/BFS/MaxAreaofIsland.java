package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {
    public static void main(String[] args) {

    }
    public static int MaxAreaofIsland(int[][] grid ){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];
                        area++;  // Count this cell

                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
                                    && grid[nx][ny] == 1 && !visited[nx][ny]) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
