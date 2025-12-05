package Heap;

import java.util.*;

public class tr {
    public static void main(String[] args) {
      String[][] word={{"abv","2.0"},{"ced","3.0"},{"cbv","3.0"},{"fed","4.0"}};
        System.out.println(kSmallestPairs(word));
    }
    public static List<String> kSmallestPairs(String[][] word){

    List<String> result = new ArrayList<>();
    Map<String,Integer>map = new HashMap<>();
    for (int i=0;i<word.length;i++){
        map.put(word[i][0],Integer.parseInt(word[0][i]));
    }
    for (Map.Entry<String,Integer> entry : map.entrySet()){
        System.out.println(entry.getKey()+entry.getValue());
    }
    return result;

    }


}
