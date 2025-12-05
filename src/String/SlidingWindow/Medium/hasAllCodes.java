package String.SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

public class hasAllCodes {
    public static void main(String[] args) {

    }
    public static boolean hasAllCodes(String s , int k){
        Set<String> seen= new HashSet<>();
        int total =1<<k;
        for (int i=0;i<s.length();i++){
            String sub = s.substring(i,i+k);
            seen.add(sub);
            if(seen.size()==total){
                return true;
            }
        }
        return false;
    }
}
