package Heap;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer>maxHeap = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer>minHeap = new PriorityQueue<>((a,b)->a-b);
    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian(){
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }

    }
}
