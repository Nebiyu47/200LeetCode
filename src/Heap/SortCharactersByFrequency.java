package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s ="tree";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s){
        Map<Character,Integer> map= new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap= new PriorityQueue<>((a,b)->{

            if(!a.getValue().equals(b.getValue())){
                return b.getValue()-a.getValue();
            }else {
                return a.getKey().compareTo(b.getKey());
            }
        });
        maxHeap.addAll(map.entrySet());
        StringBuilder sb= new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer>entry=maxHeap.poll();
            int size=entry.getValue();
            for (int i=0;i<size;i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
