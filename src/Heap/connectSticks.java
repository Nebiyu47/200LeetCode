package Heap;

import java.util.PriorityQueue;

public class connectSticks {
    public static void main(String[] args) {

    }
    public static int connectSticks(int[] sticks){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stick : sticks){
            minHeap.offer(stick);
        }
        int totalCost =0;
        while (minHeap.size()>1){
            int first= minHeap.poll();
            int second=minHeap.poll();
            int cost = first+second;
            totalCost+=cost;
            minHeap.offer(cost);
        }
        return totalCost;
    }
}
