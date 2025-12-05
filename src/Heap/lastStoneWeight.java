package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class lastStoneWeight {
    public static void main(String[] args) {

    }
    public static int lastStoneWeight(int[] stones){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : stones){
            maxHeap.offer(n);
        }
        while (maxHeap.size()>1){
            int first=maxHeap.poll();
            int second=maxHeap.poll();
            if(first!=second){
                maxHeap.offer(first-second);
            }
        }
        return maxHeap.isEmpty() ? 0 :maxHeap.peek();
    }
}
