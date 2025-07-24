package Heap;

import java.util.*;

public class topKFrequent {
   public static List<Integer> topKfrequent(int[ ] nums , int k) {


       Map<Integer, Integer> feeqMap = new HashMap<>();

       for (int n : nums){
           feeqMap.put(n, feeqMap.getOrDefault(n,0)+1);
       }
       PriorityQueue<Map.Entry<Integer,Integer>> entries= new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
       for (Map.Entry<Integer,Integer> entry : feeqMap.entrySet()){
           entries.offer(entry);
           if(entries.size()>k){
               entries.poll();
           }
       }
       List<Integer> result = new ArrayList<>();
       while (!entries.isEmpty()){
           result.add(entries.poll().getKey());
       }
       Collections.reverse(result);
       return result;

   }
}
