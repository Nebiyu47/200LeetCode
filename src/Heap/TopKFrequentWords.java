package Heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {

    }
    public static List<String> TopKFrequentWord(String [] words , int k) {

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> entryPriorityQuen = new PriorityQueue<>(

            (a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue(); // higher freq first
                } else {
                    return a.getKey().compareTo(b.getKey()); // lexicographical order
                }
            }
        );
        entryPriorityQuen.addAll(frequency.entrySet());
        List<String> result = new ArrayList<>();
        while (!entryPriorityQuen.isEmpty()) {
            if (k != 0) {
                result.add(entryPriorityQuen.poll().getKey());
            }
            k--;
        }
        return result;
    }
}
