package String.SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    public static void main(String[] args) {
        String s="12";

    }
    public static int numDecodings(String s){
        Set<String>set= new HashSet<>();
        for (int i =0;i<s.length();i++){
            for (int j=0;j<s.length();j++){
                String sub =s.substring(i,j);
                int value= Integer.parseInt(sub);
                if(value<=26){
                    set.add(String.valueOf((char) ('a'+value-1)));
                }
            }
        }
        return set.size();
    }
}
