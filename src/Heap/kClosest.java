package Heap;

import java.util.PriorityQueue;

public class kClosest {
    public int[][] Kcolest(int[][] points , int k ){
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->distance(b)-distance(a));
        for (int [] point: points){
            maxHeap.offer(point);
            while (maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int [][] result = new int[k][2];
        int index=0;
        for (int [] point :maxHeap){
            result[index++]=point;
        }
        return result;
    }
    private int distance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
