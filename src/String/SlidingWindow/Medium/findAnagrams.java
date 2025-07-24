package String.SlidingWindow.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s , String p){
        List<Integer> result = new ArrayList<>();
        int[] pCount= new int[26];
        int[] sCount= new int[26];
        for (int c :p.toCharArray()){
            pCount[c-'a']++;
        }
        for (int i =0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;

            if(i>=p.length()){
                sCount[s.charAt(i-p.length())-'a']--;

            }
            if(Arrays.equals(sCount,pCount)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}
