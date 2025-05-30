package DFS;

import java.util.*;

public class openLock {
    public static void main(String[] args) {

    }
    public static int openLock(String[] deadebs , String target){
        Set<String> dead= new HashSet<>(Arrays.asList(deadebs));
        Set<String>visted= new HashSet<>();
        Queue<String>queue= new LinkedList<>();
        queue.offer("0000");
        visted.add("0000");
        int steps=0;
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i=0;i<size;i++){
                String lock=queue.poll();
                if (lock.contains(target)) return steps;
                for (String neigbor : getNegibors(lock)){
                    if(!dead.contains(neigbor)&&!visted.contains(neigbor)){
                        visted.add(neigbor);
                        queue.offer(neigbor);
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    public static List<String> getNegibors(String lock){
        List<String> negibots= new ArrayList<>();
        char [] chars = lock.toCharArray();
        for (int i=0;i<4;i++){
            char original=chars[i];
            if(original=='9'){
                chars[i]='0';
            }else {
                chars[i]=(char) (original+1);
            }
            negibots.add(new String(chars));
            if(original=='0'){
                chars[i]='9';
            }else {
                chars[i]=(char) (original-1);
            }
            negibots.add(new String(chars));
            chars[i]=original;
        }
        return negibots;
    }
}
