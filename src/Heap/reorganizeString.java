package Heap;

import java.util.PriorityQueue;

public class reorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("abbb"));
    }
    public static String reorganizeString(String s){
        int [] freq= new int[26];
        for (char c :s.toCharArray()){
            freq[c-'a']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->
                freq[b-'a']-freq[a-'a']);
        for (char c='a';c<='z';c++){
            if(freq[c-'a']>0){
                maxHeap.offer(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (maxHeap.size()>1){
            char first= maxHeap.poll();
            char second=maxHeap.poll();
            result.append(first);
            result.append(second);
            freq[first-'a']--;
            freq[second-'a']--;
            if(freq[first]-'a'>0)maxHeap.offer(first);
            if(freq[second]-'a'>0)maxHeap.offer(second);
        }
        if(!maxHeap.isEmpty()){
            char last= maxHeap.poll();
            if(freq[last-'a']>1)return "";
        }
        return result.toString();

    }
}
