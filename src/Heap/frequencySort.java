package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class frequencySort {
    public static String frequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        maxHeap.addAll(freq.entrySet());
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer>entry = maxHeap.poll();
            char c= entry.getKey();
            int fewq = entry.getValue();
            for (int i =0;i<fewq;i++){
                result.append(c);
            }
        }
        return result.toString();
    }
}
