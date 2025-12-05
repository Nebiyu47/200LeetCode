package String.SlidingWindow.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    public static void main(String[] args) {

        String s = "00110110";
        int k=2;
        System.out.println(hasAllcodes(s,k));
    }
    public static boolean hasAllcodes(String s , int k){

        Set<String>set = new HashSet<>();

         for (int i=0;i<=s.length()-k;i++){
             String sub = s.substring(i,i+k);
             set.add(sub);
         }
         int need = (int ) Math.pow(2,k);

         return set.size()==need;

    }
}
