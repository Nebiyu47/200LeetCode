package Heap;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        int [] nums ={3,2,1,5,6,4};

        System.out.println(KthLargestElementinanArray(nums,2));
    }
    public static int KthLargestElementinanArray(int[] nums , int k){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
        for (int n : nums){
            maxHeap.offer(n);
        }

        for (int n : nums){
            minHeap.offer(n);
        }
        for (int i=0;i<k-1;i++)   {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
