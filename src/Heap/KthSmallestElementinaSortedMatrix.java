package Heap;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
   int [][] grid ={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(KthSmallestElementinaSortedMatrix(grid,8));
    }
    public static int KthSmallestElementinaSortedMatrix(int[][] grid , int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->a-b);
        for (int i=0;i< grid.length;i++){
            for (int j=0;j< grid[0].length;j++){
                priorityQueue.offer(grid[i][j]);
            }
        }
        while (!priorityQueue.isEmpty()&&k>1){


                priorityQueue.poll();
                k--;

        }
        return priorityQueue.peek();
    }
}
