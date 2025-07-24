package Heap;

import java.util.PriorityQueue;

public class KthLargestStream {
    private PriorityQueue<Integer>minHeap;
    private int k ;
    public  KthLargestStream(int k ,int [] nums){
        this.k=k;
        minHeap=new PriorityQueue<>();
        for (int n : nums){
            minHeap.offer(n);
        }
    }
    public int add(int val){
        minHeap.offer(val);
        while (minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
