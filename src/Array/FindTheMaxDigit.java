package Array;

import java.util.*;

public class FindTheMaxDigit {
    public static void main(String[] args) {
        System.out.println(findMax(578));
    }
    public static int findMax(int  n){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer a)->a).reversed());
        int total=0;
        List<Integer> list = new ArrayList<>();
        while (n>0){
            int digt= n%10;
            pq.offer(digt);
            n=n/10;
        }
       int result=0;
        while (!pq.isEmpty()) {

          result =result*10+pq.poll();
        }
      return result;
    }
}
