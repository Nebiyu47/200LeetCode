package Heap;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        int [] nums ={3,2,1,5,6,4};

        System.out.println(KthLargestElementinanArray(nums,2));
    }
    public static int KthLargestElementinanArray(int[] nums , int k){

       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
       for (int num : nums){
           maxHeap.offer(num);
       }
       while (!maxHeap.isEmpty()&&k-->1){
           maxHeap.poll();
       }
       return maxHeap.peek();
    }
}
