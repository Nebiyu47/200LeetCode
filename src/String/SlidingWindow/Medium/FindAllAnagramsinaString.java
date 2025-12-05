package String.SlidingWindow.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
     String  s = "cbaebabacd", p = "abc";

    }
    public static List<Integer> findAngrams(String s , String p ){

        List<Integer> result = new ArrayList<>();
        int[] scount= new int[26];
        int[] pcount=new int[26];

        for (char c : p.toCharArray()){
            pcount[c-'a']++;
        }
        for (int i =0;i<s.length();i++){

            scount[s.charAt(i)-'a']++;
            if(i>=p.length()){
                scount[s.charAt(i-p.length())-'a']--;

            }
            if(Arrays.equals(scount,pcount)){
                result.add(i-p.length()+1);
            }

        }
return result;
    }

}
