package Heap;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k , int[] nums){

        minHeap=new PriorityQueue<>((a,b)->a-b);

        for (int n : nums){
            minHeap.offer(n);
        }
    }
    public int add( int val){

        minHeap.offer(val);

        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

    }
}
