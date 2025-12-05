package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        int k = 3;
        System.out.println(FindKPairswithSmallestSums(nums1,nums2,k));
    }

    public static List<List<Integer>> FindKPairswithSmallestSums(int[] nums1, int[] nums2, int k) {

       List<List<Integer>> result = new ArrayList<>();
       PriorityQueue<List<Integer>>pq = new PriorityQueue<>((a,b)->sum(a)-sum(b));
       for (int i=0;i<nums1.length;i++){

           for (int j=0;j<nums2.length;j++){
                 List<Integer> pair = new ArrayList<>();
                 pair.add(nums1[i]);
                 pair.add(nums2[j]);
                 pq.offer(pair);
           }
       }
       while (!pq.isEmpty()&&k-->0){
           result.add(pq.poll());
       }
       return result;
    }
    private static int sum(List<Integer> pair){
        return pair.get(0)+pair.get(1);
    }
}
